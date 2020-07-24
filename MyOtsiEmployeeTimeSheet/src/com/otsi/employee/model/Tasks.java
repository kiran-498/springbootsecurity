package com.otsi.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Tasks{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int task_id;
	
	private String Phase;
	
	
	@NotNull
		
		@Pattern(regexp="[a-zA-Z][a-zA-Z ]*" ,message="allows only characters")
		
		    @Size(min = 20, max = 350)
	private String description;

	public int getTask_id() {
		return task_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getPhase() {
		return Phase;
	}

	public void setPhase(String phase) {
		Phase = phase;
	}
	
}