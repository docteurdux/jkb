# JKB 000 001 : Hello world Java main

## 1. Hello World

In this tutorial, we will create a simple Hello World Java project with Eclipse Oxygen and Maven.

## 2. Some context

Coming to life can be a painful experience. The newborn must get acquainted with the new substnace which is air, the lungs trigger a breathing reflex when the respiratory tract is not ready yet, and, as if that was not sufficient, the body receives is beaten until expected tears shows and loud sound is heard.

Starting in the Java World can be a frustrating experience. True, a JDK and a text editor is only what is needed to edit and compile simple Java source files. But to enjoy the experience, features such as syntax highlighting, code completion, error detection, debugging, import management and refactoring tools quickly become necessary.

This is where integrated development environments (IDEs) come to the picture, and with them come the first variable of frustration. Popular choice include Eclipse, NetBeans, IntelliJ IDEA, XCode and JBuilder, among others, which is enough to make sure that online resources almost never use your IDE of choice.

At some point, a project needs to be built, and IDE are almost always unable to address relatively complex scenarios. Not so long ago, this task was to be handled by Makefiles or Apache ANT, and this was quite good, but one aspect these tools were missing is the problem of dependency management.

Most software is built and top of the JDK and other software libraries, which are scattered accross the web, and it include each of them manually into each project, which was quite tedious and error-prone.

As of today, Maven is the almost universal solution to both build and dependency management. The Maven website host almost all Java software in the world, and these are retrieved automatically when projects are built. The build process itself is made of plugins which are retrieved too.

Not so long ago, Maven was a separate tool, and the integration with other IDE was a work in progress, but this integration has become tighter and tighter, to the point that Maven is now bundled inside many IDEs.

One problem of Maven is that the build process is described declaratively and not very flexible. Gradle is a more recent tool that uses Groovy to describe the build process in a procedural way. Although quite promising, the integration of Gradle with IDEs is still a work in progress.

In JKB, we will mostly use Eclipse IDE with Maven, and Git for versioning on GitHub, and Windows as the operating system.

## 3 Setup

In this section, we guide you in the setup of a Java development enviromnent.

### 3.1 JDK

First, get a Java SE Development Kit (JDK). At the time of writing (january 2018), the safest bet is JDK 8. Just enter "JDK 8" in your favorite search engine, and follow the link.

Next, tick the license agreement and get the latest version for Windows x64. At the time of writing, the file was named jdk-8u162-windows-x64.exe.

During installation, make sure that the source code is included, because that can be useful when debugging. Also make sure the Public JRE is not included. The JDK already comes with a JRE within. If you add the Public JRE, and then you update Java when it asked for updates, you'll end up with an updated Public JRE, but a not-updated JDK with a not-updated internal JRE. The Development Tools module is required of course.

### 3.2 Eclipse

Go to the [Eclipse](http://www.eclipse.org/) website and get the latest version. You should see things such as "Download" and "Download 64 BIT". At the time of writing, the latest version is Oxygen. You should end up with a small installer.

Eclipse support Java, Java EE, C/C++, Web, PHP and some more exotic kinds of development. The Java version setup is quite small, but you'll be happy to have gotten the Java EE version when you start doing Java EE stuff. So choose Java EE.

## 4 Creating a Maven project

There are various ways of creating projects in Eclipse. You can create a standard Eclipse project, and bind it to Maven later, or start right with a Maven project. We'll do the later option.

In the "File" menu, choose "New", then "Other...". In the "Maven" section, choose "Maven Project".

At this point, my favorite way of doing things is as follow. First, check "Create a simple project". Uncheck "Use default Workspace location" and specify a custom directory, and remember that directory will receive the project pom.xml. 

Next, specify the mandatory Group Id and Artifact Id. For projects that are not hosted anywhere, I tend to use something like "local.me" for Group Id, and a simple descriptive word for Artifact Id, and I leave the version to the default value of "0.0.1-SNAPSHOT".

For this example, use "jar" for packaging. "war" is for Java EE Web Archives, "ear" is for Java EE Enterprise Archives, and "pom" is for parent Maven projects which define Maven modules.

## 5 Importing an exidting Maven project.

To import a Maven project into eclipse, in the "File" menu, choose "Import...". In the Maven section, choose "Existing Maven Project". Then browse to the location of the project, and click "Finish".

## 6 Creating the program

In the "File" menu, choose "New...", then "Class".

Specify "local.me.myproject" as Package Name, and "Main" for the name of the class.

Between the curly braces in the generated, type "main", hit "Ctrl+Space", and choose "main method".

Then type "sysout", hit "Ctrl+Space", then type "Hello World!".

Hit "Ctrl+F".

Here's the expected result:

```java
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
```

Now double click on "main" with your mouse, then right click, and choose "Run As", then "Java Application" in the context menu.

The Console should appear with "Hello World!" in it.

Congratulations, you've done it.


## 6 Questions ?

Starting can be tough. Feel free to enter an issue in GitHub if any something was not clear. I'll answer as soon as possible. Screen sharing is also possible to troubleshoot problems in real time.













 

java main

https://en.wikipedia.org/wiki/Comparison_of_integrated_development_environments#Java

Eclipse	, NetBeans	, JBuilder	IntelliJ IDEA



Makefiles, ANT files, Gradle, Maven

