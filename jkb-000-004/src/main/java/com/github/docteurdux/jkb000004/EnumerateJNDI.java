package com.github.docteurdux.jkb000004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet("/*")
public class EnumerateJNDI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter w = response.getWriter();

		try {
			InitialContext context = new InitialContext();
			w.println();

			enumerate(context, w, "");
			
			UserTransaction  t = (UserTransaction) context.lookup("UserTransaction");
			
			w.println(t.getStatus());
			
			t.begin();
			
			w.println(t.getStatus());
			
			t.commit();
			
			w.println(t.getStatus());

		} catch (NamingException | SystemException | NotSupportedException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			w.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}

	public void enumerate(Context context, PrintWriter w, String prefix) throws NamingException {

		NamingEnumeration<NameClassPair> pairs = context.list("");
		while (pairs.hasMoreElements()) {
			NameClassPair pair = pairs.nextElement();
			String name = pair.getName();
			try {
				Object object = context.lookup(pair.getName());
				if (context != null) {
					if (object instanceof Context) {
						enumerate((Context) object, w, prefix + name + "/");
					} else {
						Class<? extends Object> clazz = object.getClass();
						w.println((prefix) + name + " : " + clazz.getName());
						dumpi(w, clazz);
						while (clazz.getSuperclass() != null) {
							w.println("> " + clazz.getSuperclass().getName());
							dumpi(w, clazz.getSuperclass());
							clazz = clazz.getSuperclass();
						}
						w.println();
					}
				}
			} catch (NamingException | ClassCastException e) {
				w.println(e.getClass().getName() + " : " + e.getMessage());
			}
		}
	}

	private void dumpi(PrintWriter w, Class<?> clazz) {
		for (Class<?> i : clazz.getInterfaces()) {
			w.println("  " + i.getName());
			if(clazz.getSuperclass() != null) {
				dumpi(w, clazz.getSuperclass());
			}
		}

	}
}
