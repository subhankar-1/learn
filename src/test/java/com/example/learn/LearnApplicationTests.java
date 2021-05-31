package com.example.learn;

import com.example.learn.dao.EmployeeRepo;
import com.example.learn.model.Employee;
import com.example.learn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;;
import static org.mockito.Mockito.when;

@SpringBootTest
class LearnApplicationTests {

	@Autowired
	EmployeeRepo repo;

	@Autowired
	EmployeeService employeeService;

	@MockBean
	EmployeeRepo repoMock;

	@Test
	void contextLoads() {
	}

	@Test()
	public void testFindByDepartment(){
		try{
			Employee employee=repo.findByDepartment("as");
			Assert.assertEquals("as", employee.getName());
			Assert.assertEquals(1,employee.getAge());
			Assert.assertEquals("as", employee.getDepartment());
		}
		catch (NullPointerException e){
			Assert.fail("null pointer exception");
		}
		return;
	}

	@Test()
	public void testFindByAge(){
		try{
			Employee employee=repo.findByAge(1);
			Assert.assertEquals("as", employee.getName());
			Assert.assertEquals(11,employee.getId());
			Assert.assertEquals("as", employee.getDepartment());
		}
		catch (NullPointerException e){
			Assert.fail("null pointer exception");
		}
		return;
	}

	@Test()
	public void testAddEmployee(){
		Employee employee = new Employee();
		employee.setAge(21);
		employee.setId(10);
		employee.setDepartment("cse");
		employee.setName("Sub");
		when(repoMock.save(employee)).thenReturn(employee);
		Assert.assertEquals(employee, employeeService.addEmployee(employee));
	}


}
