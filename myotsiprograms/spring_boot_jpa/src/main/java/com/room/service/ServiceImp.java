package com.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.room.dao.EmployeeRepository;
import com.room.dto.EmployeeDto;

@Transactional
@Service
public class ServiceImp implements ServiceInt{

	@Autowired
	private EmployeeRepository employeeRepository;
	public String saveEmployee(EmployeeDto employee) {
		employeeRepository.save(employee);
		return null;
	}

}
