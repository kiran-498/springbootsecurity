package com.otsi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.dao.EmployeeDao;
import com.otsi.dto.Employee;

@RestController
public class Controller {
	
@Autowired
private EmployeeDao employeeDao;

@RequestMapping(method = RequestMethod.GET, value="/createUserDocument")
public String createEmployee()
{
	/*Employee employee = new Employee();
	employee.setId(UUID.randomUUID());
	employee.setEmpId(UUID.randomUUID());
	employee.setName("sai");
	employee.setAddress("vijayawada");
	employeeDao.createEmployeeDao(employee);
	if(employeeDao == null)
	{
	return "sai";//
	}*/
	return "kiran";
	
}


@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
@ResponseBody
public String saveProduct(@RequestBody Employee employee) {
	
	employeeDao.save(employee);
	
	return "";
   
}

@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
public List<Employee> getData(@PathVariable("id") String id)
{
	List<Employee> employee = employeeDao.findById(id);
	return employee;
	
}
}
