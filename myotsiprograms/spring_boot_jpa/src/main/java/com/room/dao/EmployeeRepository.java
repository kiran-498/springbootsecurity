package com.room.dao;

import org.springframework.data.repository.CrudRepository;

import com.room.dto.EmployeeDto;

public interface EmployeeRepository extends CrudRepository<EmployeeDto, String>{

}
