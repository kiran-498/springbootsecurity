package com.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.room.dto.EmployeeDto;
import com.room.service.ServiceInt;



@RestController
//@RequestMapping(value = "profile")
public class RoomController {

	@Autowired
	private ServiceInt serviceInt;
	
	@RequestMapping(value ="save" , method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public String saveEmployee(@RequestBody  @Validated EmployeeDto employee)
	{
		serviceInt.saveEmployee(employee);
		return null;
		
	}
}
