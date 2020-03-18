package com.jtonna.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
