package com.tw.apistackbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CompanyResource {
    private CompanyService companyService;
    private final Logger log = Logger.getLogger(this.getClass().getName());
    @Autowired
    public CompanyResource(CompanyService service){this.companyService = service;}

    @GetMapping(value = "/companies", produces = "application/json")
    List<Company> getAllCompany(){
        return this.companyService.getAllCompany();
    }

    @PostMapping(value = "/companies", produces = "application/json")
    String addNewCompany(@RequestBody Company company){
        companyService.addNewCompany(company);
        return "New Company added.";
    }
    @GetMapping(value = "/companies/{id}", produces = "application/json")
    Company getCompanyByIndex(@PathVariable int id){
        return this.companyService.getCompanybyIndex(id);
    }
    @GetMapping(value = "/companies/{index}/employees", produces = "application/json")
    List<Employee> getEmployeeByCompany(@PathVariable int index)
    {
        return this.companyService.getEmployeebyCompany(index);
    }


}
