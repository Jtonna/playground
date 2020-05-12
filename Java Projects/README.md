# Java Projects

Welcome to the Java Projects Repo. Most of the work i do here is for personal use, just testing out logic & design patterns as well as learning new tricks.

Each project is going to be listed below along with resources (if any) that I found useful in understanding concepts.

#### Software Used

- Intellij

- Java 11

- Maven 3 (bundled with intellij)

- Tomcat 9

- Postgres SQL 12.2



# Projects

### Hello World

Everyone should know what a "hello world" project is. It is the most basic introduction to console logging (or printing information) to the developer. 

Steps to compile

1. From the SRC directory in command/bash run
2. javac hello/*.java
3. jar cvfe hellothere.jar hello.HelloWorld hello/*.class
4. java -jar hellothere.jar

The link below explains the compile commands listed above.

https://docs.oracle.com/javase/6/docs/technotes/tools/solaris/jar.html



## Transportation

This application demonstrates the difference's between Abstract Classes & Interfaces.

There is an animal interface and a vehicle one, for all animals and vehicles to use to do things like "move" & "eat / refuel".

Then there is the AbstractVehicle which has the ability to "move", "get fuel" & "add fuel". And we create horses & cars from it, whilst giving each of those childs classes custom methods and full access to the parent methods.



## EmployeeAPP

This is a simple application that visits use of constructors, static and instance variables (fields), accessors, public and private methods.

The application is simple; there are employees who have values associated with their object that allow them to be associated with a "company" by a company ID. and using the same logic for companies we can also give employees access to healthplans.



## Intro To Maven Spring Tomcat

This application has the same concepts as EmployeeAPP, except the employees data is accessible over a REST API. There is also a specific GET endpoint that allows you to pass in a float value to see what the employees salary would look like if you gave them a raise. It also utilizes the 200 response that is (OK)

https://restfulapi.net/





## Dogs Exceptions

This application builds on the previous project (Intro to maven spring tomcat) but builds upon it through error handling. We are able to successfully give the user error messages if the server receives the wrong data type through a URI GET Request. If the user accesses an endpoint that doesn't exist or more simply and commonly, requests some data the we don't have, such as information about a specific dog breed that we don't have stored.