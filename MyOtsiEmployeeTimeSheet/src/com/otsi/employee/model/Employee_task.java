package com.otsi.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee_task")
public class Employee_task{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	private int task_id;
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@NotNull
	@Past (message="Only the past is valid")
	@Column(name = "start_date", nullable = false)
	private Date start_date;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@NotNull
	@Future (message="Only the future is valid")
	@Column(name = "end_date", nullable = false)
	private Date end_date;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	

	

	
	
}
