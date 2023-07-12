package com.spring.mysql.repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mysql.model.Employee;
import com.spring.mysql.model.EmployeeRowMapper;
import com.spring.mysql.model.StateRowMapper;
import com.spring.mysql.model.Country;
import com.spring.mysql.model.Department;
import com.spring.mysql.model.DepartmentRowMapper;
import com.spring.mysql.model.State;
import com.spring.mysql.model.*;

@Transactional
@Repository
public class EmployeeRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Employee> getAllEmployees() {
		String sql = "select e.id,employee_fname,employee_lname,d.Department_Name,contact_no,email,Address_1,\r\n"
				+ "Address_2,city,s.State_Name,c.Country_name,dob\r\n"
				+ "from employee e\r\n"
				+ "inner join department d \r\n"
				+ "on e.department_id=d.Department_Id\r\n"
				+ "inner join country c\r\n"
				+ "on c.Country_id=e.Country_id\r\n"
				+ "inner join state s\r\n"
				+ "on s.State_Id=e.State_Id;";
		// RowMapper<Article> rowMapper = new
		// BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	  }
	
	public List<State> getAllStates(){
		String sql = "select state_id,state_name from state;";
		RowMapper<State> rowMapper = new StateRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Department> getAllDepartments(){
		String sql = "select  department_id,department_name from department;";
		RowMapper<Department> rowMapper = new DepartmentRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Country> getAllCountries(){
		String sql = "select country_id,country_name from Country;";
		RowMapper<Country> rowMapper = new CountryRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public int registerNewEmployee(Employee employee) {
		
		  jdbcTemplate.setResultsMapCaseInsensitive(true);
				
		  SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
	                .withProcedureName("AddEmployeeData");
		  executor.addDeclaredParameter(new SqlParameter("employee_fname", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("employee_lname", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("dept_name", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("contact_no", Types.BIGINT));
		  executor.addDeclaredParameter(new SqlParameter("email", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("Address_1", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("Address_2", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("city", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("state", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("country", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("dob", Types.DATE));
		  
		  MapSqlParameterSource inParams = new MapSqlParameterSource();
		  inParams.addValue("employee_fname", employee.getEmployeeFname());
		  inParams.addValue("employee_lname", employee.getEmployeeLname());
		  inParams.addValue("dept_name", employee.getDepartmentName());
		  inParams.addValue("contact_no", employee.getContactNo());
		  inParams.addValue("email",employee.getEmail());
		  inParams.addValue("Address_1", employee.getAddress1());
		  inParams.addValue("Address_2", employee.getAddress2());
		  inParams.addValue("city", employee.getCity());
		  inParams.addValue("state", employee.getState());
		  inParams.addValue("country", employee.getCountry());
		  inParams.addValue("dob", employee.getDob());
		  
		  Map<String, Object> out = executor.execute(inParams);
		  
		 return (int)out.get("employee_id");
		  
		  
	  }
	  public void deleteEmployee(int id) {
		  //String sql = "delete from employee where email =" + "'" + email + "'" + ";";
		  String sql = "delete from employee where Id =" + id;
		  this.jdbcTemplate.update(sql);
	  }
	
	
	

}
