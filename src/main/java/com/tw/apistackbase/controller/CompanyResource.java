package com.tw.apistackbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
