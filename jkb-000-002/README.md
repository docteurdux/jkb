# JKB 000 002 : Hello world Java servlet

In this tutorial, we create a simple servlet and invoke it with GlassFish.

## 1. Context

Java EE is a set of specifications. The Web Profile is a subset of the Full Profile.

Both profiles are implemented by a number of free or commercial application servers.

Glassfish is the reference implementation of Java EE, and comes in both profile.

Other popular examples include Tomcat (web profile), Wildfly (full profile), Jetty, Oracle WebLogic Server, or IBM WebSphere. 


Servlets only require a web profile, but it always good to learn on a full profile.

## 2. Setup

JKB 000 001 defines how to set up a simple Maven project in Eclipse.

In this tutorial, we will add some dependencies to the project, and setup a glassfish server in Eclipse.

### 2.0 Create the project


Do as in JKB 000 001, but choose "war" packaging instead of "jar".

### 2.1. Get Glassfish

To get glassfish, enter "Java EE SDK" in your favorite search engine.

You should land on a page about GlassFish for Java EE 8. Unfortunately, Java EE 8 comes with Java 9, whose support is quite fresh, so you should get the Java EE 7 Full Profile SDK in the previous releases section, which is also labeled "Java Platform, Enterprise Edition 7 SDK Update 3".

Accept the license agreement, then download the "java_ee_sdk-7u3.zip" archive.

Unpacking the archive in "C:\glassfish" is common practice. Check that "C:\glassfish4\glassfish\bin\startserv.bat" is a valid path, and correct things appropriately otherwise.

### 2.2. Glassfish Tools

The next step is to install the GlassFish Tools from Eclipse MarketPlace in the "Help" menu. It is as simple as searching for it then following the steps, and restarting Eclipse when done.

### 2.2. Defining a server

You should see a "Server" tab at the bottom of your screen. Otherwise, in the "Window" menu, choose "Show View", then "Other...", then in the "Server" section, choose "Server".

It should say "No servers are available. Click this link to create a new server...". Click the link.

In the Glassfish section of the "New server" screen, choose "Glassfish", leave "localhost" as server's host name, and name it "glassfish" or keep the default name.

Location is "C:\glassfish4" if you followed along, and the Java location should be found automatically. If not, it is "C:\Program Files\Java\jdk1.8.0_162" or something similar depending on your situation.

Leave the Application Server properties to the default, and click Finish.

## 3. Dependencies

In the file 'pom.xml', add the following properties, which tell Java/Maven to expect the version 1.8 of the language. It defaults to an older version otherwise, and triggers some warnings.

```xml
<properties>
	<maven.compiler.source>1.8</maven.compiler.source>
	<maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

Next step is to add the Java EE dependency. At [MVN Repository](https://mvnrepository.com/), search for "javaee-api". The first result should be "Java(TM) EE 8 Specification APIs" (javax>>javaee-api).

Clicking on "javaee-api" there should lead you to the list of versions, which include "6.0", "7.0" and "8.0" for each verson of Java EE. Choose the version "7.0" which is for Java EE 7, and copy the chunk of XML into the POM (the file "pom.xml"):

```xml
<dependencies>
	<dependency>
		<groupId>javax</groupId>
		<artifactId>javaee-api</artifactId>
		<version>7.0</version>
		<scope>provided</scope>
	</dependency>
</dependencies>
```

## 4. web.xml

Eclipse can generate the "web.xml" file automatically. It is supposed to guess automatically which version to generate from the pom.xml, but it may fail the first time.

 In the "Project Explorer" view, right click on the root of the tree, and select "Jave EE Tools", then "Generate Deployment Descriptor Stub".
 
 A file named "web.xml" should appear in "src\main\webapp\WEB-INF", and the version attribute of the root element should read "3.1".
 
 If it is "2.5" instead, delete the file and repeat the procedure. Choosing "Maven", then "Update..." in the context menu of the root of the tree in "Project Explorer" may help.
 
 ## 5. Creating a servlet at last
 
Hit "Ctrl+N" and select "Class", and give it a name.

Make it extend javax.servlet.http.HttpServlet , use Ctrl+Space for autocompletion and autoimport.

Type a "d", choose "doGet", and let Eclipse do the rest.

Replace the generated implementation with something that says "Hello World!". 

At the top of the class, add a WebServlet annotation, and give it "/hello" as value.

Here's the expected result.

```java
@WebServlet("/hello")
public class S extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello world!");
	}
}
```

## 6. Test it

In the "Servers" view, right click on the glassfish server, and choose "Add and Remove...".

Click on your project, then on "Add >", then on "Finish".

Right click on the server, then choose "Start", and wait until the console stop spitting information.

You should see that your project was successfully deployed in the console.

In the "Servers" view, choose "GlassFish", then "View Admin Console".

In "Common Tasks", choose "Applications", then "Launch", then the first HTTP url.

In the address field, append "hello".

If you see "Hello world!" there, congratulations, you've done it.

## 7. Questions ?

Feel free to open an issue if you had trouble with this tutorial.