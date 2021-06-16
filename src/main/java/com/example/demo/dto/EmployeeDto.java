package com.example.demo.dto;

import com.example.demo.entity.Employee;

public class EmployeeDto {
	private int employeeId;
	private String fullName;
	private String employeeCode;
	private String phone;
	private String age;
	private String email;
	
	public EmployeeDto(Employee entity) {
		this.employeeId = entity.getEmployeeId();
		this.employeeCode = entity.getEmployeeCode();
		this.fullName = entity.getFullName();
		this.phone = entity.getPhone();
		this.age = entity.getAge();
		this.email = entity.getEmail();
	}
	
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
