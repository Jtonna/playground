package com.jtonna.webemployees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee
{
    private final static AtomicLong counter = new AtomicLong(); // used to give users a unique ID
    private long id;
    private String fname;
    private String lname;
    private double salary;
    private boolean has401K;
    private int companyID;
    private int healthPlanID;

    // Constructor
    public Employee(String fname, String lname, double salary, boolean has401K, int companyID, int healthPlanID)
    {
        this.id = counter.incrementAndGet(); // Assign the id using a built in function.
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.has401K = has401K;
        this.companyID = companyID;
        this.healthPlanID = healthPlanID;
    }

    // Getters and Setters

    // The ID gets set automatically so we dont want a setter, just a getter
    public long getId()
    {
        return id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public boolean isHas401K()
    {
        return has401K;
    }

    public void setHas401K(boolean has401K)
    {
        this.has401K = has401K;
    }

    public int getCompanyID()
    {
        return companyID;
    }

    public void setCompanyID(int companyID)
    {
        this.companyID = companyID;
    }

    public int getHealthPlanID()
    {
        return healthPlanID;
    }

    public void setHealthPlanID(int healthPlanID)
    {
        this.healthPlanID = healthPlanID;
    }

    // toString for console logging
    @Override
    public String toString()
    {
        return "Employee{" + "id=" + id + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", salary=" + salary + ", has401K=" + has401K + ", companyID=" + companyID + ", healthPlanID=" + healthPlanID + '}';
    }
}
