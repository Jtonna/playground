package com.jtonna.webemployees2;

import java.util.concurrent.atomic.AtomicLong;

public class Employee
{
    // Model
    private static final AtomicLong counter = new AtomicLong(); // Counter that increments by 1
    private long id;
    private String fname, lname;
    private double salary;
    private boolean has401k;
    private int companyID;
    private int healthPlanID;

}
