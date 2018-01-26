package com.github.docteurdux.jkb000001;

public class UnexpectedApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnexpectedApplicationException(Exception ex) {
		super(ex);
	}

	public UnexpectedApplicationException(String message) {
		super(message);
	}

}
