package com.example.learn.controller;

import com.example.learn.dao.EmployeeRepo;
import com.example.learn.model.Employee;
import com.example.learn.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @PostMapping("/addEmployee")
    @ResponseBody
    public Employee addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }

    @RequestMapping("/getEmployeeByAge")
    @ResponseBody
    public Employee getEmployeeByAge(@RequestParam int age){
        ModelAndView mv=new ModelAndView("showEmployee.jsp");
        Employee employee=employeeService.getEmployeeByAge(age);
        mv.addObject(employee);
        return employee;
    }

    @RequestMapping("/getEmployeeByDepartment")
    @ResponseBody
    public Employee getEmployeeByDepartment(@RequestParam String department){
        ModelAndView mv=new ModelAndView("showEmployee.jsp");
        Employee employee=employeeService.getEmployeeByDepartment(department);
        mv.addObject(employee);
        return employee;
    }
}


