package com.room.dto;

public class EmployeeDto {
	private String id;
	private String fName;
	private String lName;
	//private AddressDto address;
	//private DeportmentDto department;
	private String empId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	/*public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public DeportmentDto getDepartment() {
		return department;
	}
	public void setDepartment(DeportmentDto department) {
		this.department = department;
	}*/
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	

}
