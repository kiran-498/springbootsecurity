package com.otsi.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int project_id;
	 @NotNull
     @Size(min=3, max=100)
	 @Pattern(regexp="[a-zA-Z][a-zA-Z ]*" ,message="allows only characters")
	private String name;
    
	private String status;
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
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

