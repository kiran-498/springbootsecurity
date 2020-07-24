package com.otsi.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Address_details")
public class Address_details  {
	
	
	
	 @NotNull
     @Size(min=3, max=35)
	 @Pattern(regexp="[a-zA-Z][a-zA-Z ]*" ,message="allows only characters")
	@Column(name = "location", nullable = false)
	private String location;
	
	 @NotNull
     @Size(min=3, max=35)
	 @Pattern(regexp="[a-zA-Z][a-zA-Z ]*" ,message="allows only characters")
	@Column(name = "city", nullable = false)
	private String city;
	
	 
	 @NotNull
	 @Min(value=100000,message="invalid pincode")
	 @Max(value=999999,message="invalid pincode")
	private int pincode;
	
	
	@NotNull(message="please enter phone number")
	private long phone_no;
     
	 
    private int emp_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int addr_id;
      
      
  	public int getAddr_id() {
  		return addr_id;
  	}


  	public void setAddr_id(int addr_id) {
  		this.addr_id = addr_id;
  	}
      
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
}
	
	

	

