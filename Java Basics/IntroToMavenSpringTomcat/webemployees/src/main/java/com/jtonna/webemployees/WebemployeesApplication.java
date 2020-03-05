package com.jtonna.webemployees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebemployeesApplication
{

    // ourEmpList of type EmpList.java
    static EmpList ourEmpList;

    public static void main(String[] args)
    {
        ourEmpList = new EmpList(); // Call the List to create it.
        SpringApplication.run(WebemployeesApplication.class, args);
    }

}
