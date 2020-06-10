package com.jtonna.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/data")
public class EmployeeController
{
    // localhost:PORT/data/allemployees
    @RequestMapping(value = "/allemployees", produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees()
    {
        // Get and sort employee list by last name
        WebemployeesApplication.ourEmpList.empList.sort((e1, e2) -> e1.getLname().compareToIgnoreCase(e2.getLname()));
        // Return the employees list and an http status
        return new ResponseEntity<>(WebemployeesApplication.ourEmpList.empList, HttpStatus.OK);
    }

    // localhost:PORT/data/employee/<EMPLOYEEID>
    @GetMapping(value = "/employee/{id}", produces = {"application/json"})
    public ResponseEntity<?> getEmpDetail(@PathVariable long id)
    {
        Employee rtnEmp = WebemployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == id));
        return new ResponseEntity<>(rtnEmp, HttpStatus.OK);
    }

    // localhost:PORT/data/employees/<letter of fname>
    @GetMapping(value = "/employees/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getEmployees(@PathVariable char letter)
    {
        ArrayList<Employee> rtnEmps = WebemployeesApplication.ourEmpList.
                findEmployees( e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }
}
