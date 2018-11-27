package com.tw.apistackbase.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> allEmployee = new ArrayList<>();
    private Employee e1 = new Employee(0, "Xiaoming", 20, "M");
    private Employee e2 = new Employee(1,"Xiaohong", 19, "F");
    private Employee e3 = new Employee(2, "Xiaozhi", 15, "M");
    private Employee e4 = new Employee(3, "Xiaogang", 16, "M");
    public EmployeeService(){
        allEmployee.add(e1);
        allEmployee.add(e2);
        allEmployee.add(e3);
        allEmployee.add(e4);
    }

    public void deletebyId(int id) {
        Employee employee = null;
        for (Employee e: allEmployee){
            if (e.getId()==id) {
                employee = e;
                allEmployee.remove(e);
                break;
            }
        }
    }

    public List<Employee> getAllEmployee(){return this.allEmployee;}
    public void addNewEmployee(Employee e){
        allEmployee.add(e);
    }

    public void changeEmployeeInfo(Employee employee) {
        for (Employee e: allEmployee){
            if (e.getId() == employee.getId()){
                updateInfo(e, employee);
                break;
            }
        }
    }

    private void updateInfo(Employee oldInfo, Employee newInfo) {
        oldInfo.setAge(newInfo.getAge());
        oldInfo.setGender(newInfo.getGender());
        oldInfo.setName(newInfo.getName());
    }
}
