package com.spring.mysql.model;

import java.sql.Date;

public class Employee {
	private int Id;
	private String employeeFname;
	private String employeeLname;
	private String departmentName;
	private Long contactNo;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private Date dob;
	public String getEmployeeFname() {
		return employeeFname;
	}
	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}
	public String getEmployeeLname() {
		return employeeLname;
	}
	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getId() {
		return Id;
	}
	
	

}
