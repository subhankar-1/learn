package com.example.learn.dao;

import com.example.learn.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    Employee findByAge(int age);

    Employee findByDepartment(String department);

}




