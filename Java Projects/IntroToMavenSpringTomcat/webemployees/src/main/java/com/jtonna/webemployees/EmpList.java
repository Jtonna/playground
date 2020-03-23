package com.jtonna.webemployees;

import java.util.ArrayList;

public class EmpList
{
    // public ArrayList of class Employee named empList = a new Array list
    public ArrayList<Employee> empList = new ArrayList<>();

    // Constructor (creates objects)
    public EmpList()
    {
        // array emplist add new Employee <data>
        empList.add(new Employee("Jacob", "Tonna", 90942, true, 1 ,2));
        empList.add(new Employee("Alf", "Garsia", 24942, false, 3 ,1));
        empList.add(new Employee("Roobin", "Pantse", 67942, true, 2 ,1));
    }

    public Employee findEmployee(CheckEmployee tester)
    {
        for(Employee e: empList)
        {
            if (tester.test(e))
            {
                return e;
            }
        }
        return null; // if no employees are found
    }

    public ArrayList<Employee> findEmployees(CheckEmployee tester)
    {
        ArrayList<Employee> tempEmpList = new ArrayList<>();

        for (Employee e: empList)
        {
            if (tester.test(e))
            {
                tempEmpList.add(e);
            }
        }
        return tempEmpList;
    }
}
