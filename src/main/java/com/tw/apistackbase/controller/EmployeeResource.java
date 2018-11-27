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
    String deleteEmployee(@PathVariable int id){
        employeeService.deleteByID(id);
        return "Employee with id "+id+"deleted";
    }
    @PostMapping("/employees/{id}/{name}/{age}/{gender}")
    String addNewEmployee(@PathVariable int id, @PathVariable String name, @PathVariable int age, @PathVariable String gender){
        Employee newEmployee = new Employee(id, name, age, gender);
        employeeService.allNewEmployee(newEmployee);
        return "New Employee with name: "+name+"added.";
    }

}

