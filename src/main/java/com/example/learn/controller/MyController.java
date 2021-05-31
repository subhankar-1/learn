package com.example.learn.controller;

import com.example.learn.dao.EmployeeRepo;
import com.example.learn.model.Employee;
import com.example.learn.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/addEmployee")
    @ResponseBody
    public Employee addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }

    @RequestMapping("/getEmployeeByAge")
    public ModelAndView getAlienByAge(@RequestParam int age){
        ModelAndView mv=new ModelAndView("showEmployee.jsp");
        Employee employee=employeeService.getAlienByAge(age);
        mv.addObject(employee);
        return mv;
    }

    @RequestMapping("/getEmployeeByDepartment")
    public ModelAndView getAlienByDepartment(@RequestParam String department){
        ModelAndView mv=new ModelAndView("showEmployee.jsp");
        Employee employee=employeeService.getAlienByDepartment(department);
        mv.addObject(employee);
        return mv;
    }
}


