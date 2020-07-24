package com.otsi.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee" ,schema="public")
public class Employee {

	@Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Min(1000)
	// @Pattern(regexp="[0-9][0-9]*" ,message="allows only characters")
	//@Pattern(regexp="(^$|[0-9]{10})",message="only numbers allows")
	private int emp_id;

	 @NotNull
     @Size(min=3, max=35)
	 @Pattern(regexp="[a-zA-Z][a-zA-Z ]*" ,message="allows only characters")
	@Column(name = "fname", nullable = false)
	private String fname;
	
	/*@NotNull
	@Size(min=3, max=35)
	@Column(name = "lname", nullable = false)*/
	 @NotNull
	/* @Pattern(regexp="(^$|[0-9]{10})")*/
	@Pattern(regexp="[a-zA-Z][a-zA-Z ]*")
	
	    @Size(min = 3, max = 35)
	private String lname;
	
	@NotNull
	@Size(min=3, max=50)
	@Column(name = "email_id", nullable = false)
	private String email_id;

	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@NotNull
	@Past (message="Only the past is valid")
	@Column(name = "date_of_join", nullable = false)
	private Date date_of_join;
	
	
	/*@NotNull
	@Size(min=3, max=50)
	@Column(name = "status",  nullable = false)*/
	private String status;	

/*	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	
	private String date_of_join;*/
	




	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		
		this.emp_id = emp_id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate_of_join() {
		return date_of_join;
	}


	public void setDate_of_join(Date date_of_join) {
		
		this.date_of_join = date_of_join;
	}


	


	/*public String getDate_of_join() {
		return date_of_join;
	}


	public void setDate_of_join(String date_of_join) {
		this.date_of_join = date_of_join;
	}*/
	
	
	

}
