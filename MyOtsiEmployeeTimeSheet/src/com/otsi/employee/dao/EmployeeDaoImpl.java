package com.otsi.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.otsi.employee.model.Address_details;
import com.otsi.employee.model.Employee;
import com.otsi.employee.model.Employee_task;
import com.otsi.employee.model.Project;
import com.otsi.employee.model.Project_timesheet;
import com.otsi.employee.model.Tasks;



@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	

	public void saveEmployee(Employee employee) {
		
		persist(employee);
		
	}
	
	
	public void saveAddress(Address_details addressdetails) {
		
		persist(addressdetails);
		
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}
	
	public void deleteEmployeeByemp_id(int emp_id) {
		
		Query query1 = getSession().createSQLQuery("delete from Address_details where emp_id = :emp_id");
		query1.setInteger("emp_id", emp_id);
		query1.executeUpdate();
		Query query3 = getSession().createSQLQuery("delete from Project_timesheet where emp_id = :emp_id");
		query3.setInteger("emp_id", emp_id);
		query3.executeUpdate();
		Query query2 = getSession().createSQLQuery("delete from Employee_task where emp_id = :emp_id");
		query2.setInteger("emp_id", emp_id);
		query2.executeUpdate();
		
		Query query = getSession().createSQLQuery("delete from Employee where emp_id = :emp_id");
		query.setInteger("emp_id", emp_id);
		query.executeUpdate();
	}

	

	
	
	/*public Employee findById(int emp_id) {
		return getByKey(emp_id);
	}*/
	
	public void saveTasks(Tasks tasks)
	
	{
		persist(tasks);
	}
	
	public void saveEmployeetask(Employee_task employeetask)
	{
		persist(employeetask);
	}
	public void saveProject(Project project)
	{
		persist(project);
	}
	public void saveProjecttimesheet(Project_timesheet projecttimesheet)
	{
		persist(projecttimesheet);
	}
	public Employee findEmployeeByemp_id(int emp_id) {
		Criteria criteria = createEntityCriteria1();
		criteria.add(Restrictions.eq("emp_id", emp_id));
		return (Employee) criteria.uniqueResult();
	
		
		
	}
	
	public void updateEmployee(Employee employee)
	{
		
		
		if (employee.getEmp_id()!= 0) {
		   merge(employee);
		} else {
			update(employee);
		}
		
			
		
	
	
}


}



