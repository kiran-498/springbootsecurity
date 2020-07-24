package com.otsi.dao;

import java.io.Serializable;
import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otsi.dto.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Serializable>{

	
	public List<Employee> findById(String id);


}
