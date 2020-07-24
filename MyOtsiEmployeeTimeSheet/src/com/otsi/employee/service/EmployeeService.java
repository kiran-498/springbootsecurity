package com.otsi.employee.service;

import java.util.List;

import com.otsi.employee.model.Address_details;
import com.otsi.employee.model.Employee;
import com.otsi.employee.model.Employee_task;
import com.otsi.employee.model.Project;
import com.otsi.employee.model.Project_timesheet;
import com.otsi.employee.model.Tasks;



public interface EmployeeService {

	
	List<Employee> findAllEmployees(); 
	Employee findEmployeeByemp_id(int emp_id);
	
	void saveEmployee(Employee employee);
	void saveAddress(Address_details addressdetails);
	void saveTasks(Tasks tasks);
	void saveEmployeetask(Employee_task employeetask);
	void saveProject(Project project);
	void saveProjecttimesheet(Project_timesheet projecttimesheet);
	
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeByemp_id(int emp_id);

	/*Employee findByemp_Id(int emp_id);
	
	Employee findEmployeeByempr_id(int emp_id);

	boolean isEmployeeaddr_idUnique(Integer emp_id, int addr_id);*/
	
}