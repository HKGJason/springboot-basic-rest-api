package com.tw.apistackbase.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    EmployeeService employeeService = new EmployeeService();
    @RequestMapping(value = "/employees", produces = "application/json")
    public List<Employee> listAllEmployee(){

        return employeeService.getAllEmployee();
    }
    /*public ResponseEntity<String> getAll() {

        return ResponseEntity.ok(Employee);
        //return ResponseEntity.ok();
    }
    */
   // @RequestMapping(value = "/employees/add", produces = )
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable int id){
        employeeService.deleteByID(id);
    }
}

