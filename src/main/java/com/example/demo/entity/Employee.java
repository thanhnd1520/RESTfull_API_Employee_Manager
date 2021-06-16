package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id // trường bắt buộc phãi có nếu không bị lỗi  org.hibernate.AnnotationException:
	@Column(name = "EmployeeId")
	private int employeeId;
	@Column(name = "FullName")
	private String fullName;
	@Column(name = "EmployeeCode")
	private String employeeCode;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Email")
	private String email;
	@Column(name = "Age")
	private String age;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Employee() {
		super();
	}
	public Employee(int employeeId, String fullName, String employeeCode, String phone, String email, String age) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.employeeCode = employeeCode;
		this.phone = phone;
		this.email = email;
		this.age = age;
	}
	
	
}
