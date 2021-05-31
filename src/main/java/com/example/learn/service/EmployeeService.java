package com.example.learn.service;

import com.example.learn.dao.EmployeeRepo;
import com.example.learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo repo;

    public Employee addEmployee(Employee employee){
        repo.save(employee);
        return employee;
    }

    public Employee getAlienByAge(int age){
        return repo.findByAge(age);
    }

    public Employee getAlienByDepartment(String department){
        return repo.findByDepartment(department);
    }


}
