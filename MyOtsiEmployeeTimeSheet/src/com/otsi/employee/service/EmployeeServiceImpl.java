package com.otsi.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otsi.employee.dao.EmployeeDao;
import com.otsi.employee.model.Address_details;
import com.otsi.employee.model.Employee;
import com.otsi.employee.model.Employee_task;
import com.otsi.employee.model.Project;
import com.otsi.employee.model.Project_timesheet;
import com.otsi.employee.model.Tasks;



@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	


	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	public void saveAddress(Address_details addressdetails)
	{
		dao.saveAddress(addressdetails);
	}
	
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}
	
public void deleteEmployeeByemp_id(int emp_id) {
		dao.deleteEmployeeByemp_id(emp_id);
	}
	
	

	

	/*public boolean isEmployeeSsnUnique(Integer emp_id, int addr_id) {
		Employee employee = findEmployeeByaddr_id(addr_id);
		return ( employee == null || ((emp_id != null) && (employee.getEmp_id() == emp_id)));
	}
	
	public Employee findByemp_id(int emp_id) {
		return dao.findByemp_id(emp_id);
	}*/
	
	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findEmployeeByemp_id(employee.getEmp_id());
		if(entity!=null){
			entity.setFname(employee.getFname());
			entity.setLname(employee.getLname());
			entity.setEmail_id(employee.getEmail_id());
			entity.setDate_of_join(employee.getDate_of_join());
			entity.setStatus(employee.getStatus());
		}
		dao.updateEmployee(employee);
	}

	public Employee findEmployeeByemp_id(int emp_id) {
		return dao.findEmployeeByemp_id(emp_id);
	}
	
	public void saveTasks(Tasks tasks)
	{
		dao.saveTasks(tasks);
	}
	
	public void saveEmployeetask(Employee_task employeetask)
	{
		dao.saveEmployeetask(employeetask);
	}
	public void saveProject(Project project)
	{
		dao.saveProject(project);
	}
	
	
	public void saveProjecttimesheet(Project_timesheet projecttimesheet)
	{
		dao.saveProjecttimesheet(projecttimesheet);
	}
	
	
}
