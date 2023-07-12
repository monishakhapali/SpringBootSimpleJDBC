package com.spring.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mysql.model.Country;
import com.spring.mysql.model.Department;
import com.spring.mysql.model.Employee;
import com.spring.mysql.model.State;
import com.spring.mysql.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRespository;
	
	
	public List<Employee> getAllEmployees()
	{
		return employeeRespository.getAllEmployees();
	}
	
	public List<State> getAllStates()
	{
		return employeeRespository.getAllStates();
	}
	
	public List<Department> getAllDepartments()
	{
		return employeeRespository.getAllDepartments();
	}
	
	public List<Country> getAllCountries()
	{
		return employeeRespository.getAllCountries();
	}
	
	public int AddEmployee(Employee employee)
	{
		return employeeRespository.registerNewEmployee(employee);
	}
	public void deleteEmployee(int id) {
		employeeRespository.deleteEmployee(id);
		//return "Employee Removed !! " + id;
	} 
	

}
