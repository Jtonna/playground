package com.jtonna.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculationController
{
    // localhost:PORT/calc/salary/<employee id>/<raise amount>
    // return how much the employee would get
    @GetMapping(value = "/salary/{id}/{raise}", produces = {"application/json"})
    public ResponseEntity<?> checkRaise(@PathVariable long id, @PathVariable double raise)
    {
        Employee tempEmp = new Employee(WebemployeesApplication.ourEmpList.findEmployee(e ->(e.getId() == id)));
        tempEmp.setSalary(tempEmp.getSalary() * (1.0 + raise));
        return new ResponseEntity<>(tempEmp, HttpStatus.OK);
    }
}
