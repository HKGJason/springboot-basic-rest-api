package com.tw.apistackbase.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private Employee e1 = new Employee(0, "Xiaoming", 20, "M");
    private Employee e2 = new Employee(1,"Xiaohong", 19, "F");
    private Employee e3 = new Employee(2, "Xiaozhi", 15, "M");
    private Employee e4 = new Employee(3, "Xiaogang", 16, "M");
    @RequestMapping(value = "/employees", produces = "application/json")
    public List<Employee> listAllEmployee(){
        List<Employee> allEmployee = new ArrayList<>();
        allEmployee.add(e1);
        allEmployee.add(e2);
        allEmployee.add(e3);
        return allEmployee;
    }
    /*public ResponseEntity<String> getAll() {

        return ResponseEntity.ok(Employee);
        //return ResponseEntity.ok();
    }
    */
}

