package com.example.learn.controller;

import com.example.learn.dao.EmployeeRepo;
import com.example.learn.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    EmployeeRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        repo.save(employee);
        return "home.jsp";
    }

    @RequestMapping("/getEmployeeByAge")
    public ModelAndView getAlienByAge(@RequestParam int age){
        ModelAndView mv=new ModelAndView("showEmployee.jsp");
        Employee employee=repo.findByAge(age);
        mv.addObject(employee);
        return mv;
    }

    @RequestMapping("/getEmployeeByDepartment")
    public ModelAndView getAlienByDepartment(@RequestParam String department){
        ModelAndView mv=new ModelAndView("showEmployee.jsp");
        Employee employee=repo.findByDepartment(department);

        mv.addObject(employee);
        return mv;
    }
}


