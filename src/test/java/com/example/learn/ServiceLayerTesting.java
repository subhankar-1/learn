package com.example.learn;

import com.example.learn.dao.EmployeeRepo;
import com.example.learn.model.Employee;
import com.example.learn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceLayerTesting {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepo repoMock;

    @Test()
    public void testAddEmployee(){
        Employee employee = new Employee();
        employee.setAge(21);
        employee.setId(10);
        employee.setDepartment("cse");
        employee.setName("Sub");
        when(repoMock.findById(employee.getId())).thenReturn(employee);
        Assert.assertEquals(employee, employeeService.addEmployee(employee));
    }

    @Test()
    public void testFindByDepartment(){
        Employee employee = new Employee();
        employee.setAge(21);
        employee.setId(10);
        employee.setDepartment("cse");
        employee.setName("Sub");
        when(repoMock.findByDepartment(employee.getDepartment())).thenReturn(employee);
        Assert.assertEquals(employee,employeeService.getEmployeeByDepartment(employee.getDepartment()));
        return;
    }

    @Test()
    public void testFindByAge(){
        Employee employee = new Employee();
        employee.setAge(21);
        employee.setId(10);
        employee.setDepartment("cse");
        employee.setName("Sub");
        when(repoMock.findByAge(employee.getAge())).thenReturn(employee);
        Assert.assertEquals(employee,employeeService.getEmployeeByAge(employee.getAge()));
        return;
    }
}
