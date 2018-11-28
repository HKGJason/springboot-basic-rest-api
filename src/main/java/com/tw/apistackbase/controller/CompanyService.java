package com.tw.apistackbase.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private List<Company> allCompany = new ArrayList<>();
    private Employee e1 = new Employee(0, "Xiaoming", 20, "M", 8000);
    private Employee e2 = new Employee(1,"Xiaohong", 19, "F");
    //EmployeeService employeeService;
    private Company apple = new Company("Apple");
    private Company samsong = new Company("Samsong");
    public CompanyService(){
        //apple.hireEmployee(employeeService.getAllEmployee().get(0));
        //samsong.hireEmployee(employeeService.getAllEmployee().get(1));
        allCompany.add(apple);
        allCompany.add(samsong);
        apple.hireEmployee(e1);
        samsong.hireEmployee(e2);
    }
    public List<Company> getAllCompany(){
        return this.allCompany;
    }


    public void addNewCompany(Company company) {
        allCompany.add(company);
    }

    public Company getCompanybyIndex(int id) {
        return allCompany.get(id-1);
    }
}
