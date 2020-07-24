package com.otsi.employee.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.otsi.employee.model.Address_details;
import com.otsi.employee.model.Employee;
import com.otsi.employee.model.Employee_task;
import com.otsi.employee.model.Project;
import com.otsi.employee.model.Project_timesheet;
import com.otsi.employee.model.Tasks;



public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void persist(Address_details addressdetails) {
		getSession().persist(addressdetails);
	}
	public void persist(Tasks tasks) {
		getSession().persist(tasks);
	}
	
	public void persist(Employee_task employeetask) {
		getSession().persist(employeetask);
	}
	public void persist(Project project)
	{
		getSession().persist(project);
	}
	
	public void persist(Project_timesheet projecttimesheet)
	{
		getSession().persist(projecttimesheet);
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	public void update(T entity) {
		getSession().update(entity);
	}
	
	public void merge(T entity) {
		getSession().merge(entity);
	}
	protected Criteria createEntityCriteria(Class<Employee> class1){
		return getSession().createCriteria(persistentClass);
	}
	
	protected Criteria createEntityCriteria1(){
		return getSession().createCriteria(persistentClass);
		
		
	}

}
