# Java Basic's

This branch / folder was created to re-visit java at its core, and is mainly intended as a refresher into the language as I have been working with JavaScript, Python & C++  lately and have forgotten the syntax of the language.

Its important to not forget Java is "compiled", meaning every program has to be compiled before it can be ran. When it gets compiled it turns into Bytecode. Bytecode is what runs on multiple machines in something called a JVM "java virtual machine", this JVM is what configures the bytecode to allow your one program to run on windows, mac and linux machines without you having to create different versions of the program for multiple systems.

Every Java application has a "src" folder, this is a required name. Common folder structure should be

- AppNameHere
  - src
    - PackageNameHere (this could also be the app name if you want)
      - file - Main.java
      - other files or more folders/files



## Setup

For this branch / folder we are going to be using IntelliJ Idea Ultimate, but sublime or VS Code should work just as well.

You should make sure you're using Java 11.0.5 to ensure there's full compatibility.

Directory HelloWorld was created to just say hello world, as well as make sure compiler commands are functioning properly

Directory Syntax was created to re-visit basic syntax, it contains EmployeeAPP and SnackBar which are two different applications that are very similar in structure. They are taken from the LambdaSchool Legacy TK

Directory L33T was created to do a few popular leet code challenges in java



## How to compile

Lets assume we have a PACKAGE named hello, we would run the following command's from the "src" directory to create an executable .jar file that can run on any machine

`javac hello/*.java`

- javac = java compiler, creates .class files
- hello = directory
- /*.java = all files with the extension of .java

`jar cvfe hellothere.jar hello.HelloWorld hello/*.class`

- jar = 
- C - create new archive file with given name
- V -  generates verbose output
- F - specifies the jar output file to be created
- E -sets the main class to the called entry point

`java -jar hellothere.jar`	

- runs the jar file names hellothere.jar

## Resources

Java Docs

-  https://docs.oracle.com/en/java/javase/11/ 

