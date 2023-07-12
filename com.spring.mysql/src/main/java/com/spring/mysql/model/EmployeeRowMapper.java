package com.spring.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setEmployeeFname(rs.getString("employee_fname"));
		employee.setEmployeeLname(rs.getString("employee_lname"));
		employee.setDepartmentName(rs.getString("Department_Name"));
		employee.setContactNo(rs.getLong("contact_no"));
		employee.setEmail(rs.getString("email"));
		employee.setAddress1(rs.getString("Address_1"));
		employee.setAddress2(rs.getString("Address_2"));
		employee.setCity(rs.getString("city"));
		employee.setState(rs.getString("State_Name"));
		employee.setCountry(rs.getString("Country_name"));
		employee.setDob(rs.getDate("dob"));
		
		
		return employee;
	}
	

}
