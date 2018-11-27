package com.tw.apistackbase.controller;

import java.util.*;

public class Company {
    private String companyName;
    private int employeesNumber;
    private List<Employee> allemployee = new ArrayList<>() ;

    public Company(String name){
        this.companyName = name;
    }

    public int getEmployeesNumber() {
        return allemployee.size();
    }
    public List<Employee> getAllemployee(){
        return allemployee;
    }
    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void hireEmployee(Employee e){
        this.allemployee.add(e);
    }
}
