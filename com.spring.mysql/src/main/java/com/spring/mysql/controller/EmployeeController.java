package com.spring.mysql.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql.model.Country;
import com.spring.mysql.model.Department;
import com.spring.mysql.model.Employee;
import com.spring.mysql.model.State;
import com.spring.mysql.service.EmployeeService;

@RestController
@RequestMapping("v1")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@CrossOrigin("*")
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.getAllEmployees();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/registerNewEmployee",  consumes=MediaType.APPLICATION_JSON_VALUE)
    public int registerNewUser(@RequestBody Employee employee) {
        return employeeService.AddEmployee(employee);
    }
	@CrossOrigin("*")
	@GetMapping("states")
	public List<State> getAllState() {
		
		return employeeService.getAllStates();
	}
	@CrossOrigin("*")	
	@GetMapping("departments")
	public List<Department> getAllDepartments() {
		
		return employeeService.getAllDepartments();
	}
	
	@CrossOrigin("*")	
	@GetMapping("countries")
	public List<Country> getAllCountries() {
		
		return employeeService.getAllCountries();
	}
	@CrossOrigin("*")
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteProduct(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
	

}
