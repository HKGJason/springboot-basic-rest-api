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
    List<Company> getAllCompany(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "0") int pageSize){
        if (page != 0 && pageSize !=0)
            return this.companyService.getCompanybyPageRange(page-1, page+pageSize-1);
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
    @PutMapping(value = "/companies/{index}", produces = "application/json")
    Company updateCompanyInfo(@RequestBody Company company, @PathVariable int index){
        return this.companyService.updateCompanyInfo(index, company);
    }
    @DeleteMapping(value = "/companies/{index}",produces = "application/json")
    String deleteEmployeeBelongToCompany(@PathVariable int index){
        this.companyService.deleteEmployeeByCompany(index);
        return "Employee deleted";
    }



}
