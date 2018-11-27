package com.tw.apistackbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class EmployeeResource {
    private EmployeeService employeeService;
    private final Logger log = Logger.getLogger(this.getClass().getName());
    @Autowired
    public EmployeeResource(EmployeeService service){
        this.employeeService  = service;
    }

    @RequestMapping(value = "/employees", produces = "application/json", method = RequestMethod.GET)
    public List<Employee> listAllEmployee(@RequestParam(value = "gender", required =false, defaultValue = "null") String gender){
        if (!gender.equals("null"))
            return employeeService.findEmployeeByGender(gender);
        return employeeService.getAllEmployee();
    }

    /*public ResponseEntity<String> getAll() {

        return ResponseEntity.ok(Employee);
        //return ResponseEntity.ok();
    }
    */
   // @RequestMapping(value = "/employees/add", produces = )
    @DeleteMapping(value = "/employees/{id}")
    String deleteEmployee(@PathVariable int id){
        employeeService.deletebyId(id);
        return "Employee deleted";
    }
    /*
    @PostMapping("/employees/{id}/{name}/{age}/{gender}")
    String addNewEmployee(@PathVariable int id, @PathVariable String name, @PathVariable int age, @PathVariable String gender){
        Employee newEmployee = new Employee(id, name, age, gender);
        employeeService.allNewEmployee(newEmployee);
        return "New Employee with name: "+name+"added.";
    }
*/
    @PostMapping(value = "/employees", produces = "application/json")
    String addNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
        return "Employee with name: "+employee.getName()+" added.";
    }
    @PutMapping(value = "/employees/{id}", produces = "application/json")
    String changeEmployeeInfo(@RequestBody Employee employee, @PathVariable int id){
        employee.setId(id);
        employeeService.changeEmployeeInfo(employee);
        return "Employee info updated.";
    }
    /*
    @GetMapping(value ="/employees", produces = "application/json")
    public List<Employee> getEmployeeByGender(@RequestParam("gender") String gender){
        return employeeService.findEmployeeByGender(gender);
    }
    */

}

