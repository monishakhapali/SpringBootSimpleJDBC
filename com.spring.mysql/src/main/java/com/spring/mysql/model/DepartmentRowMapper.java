package com.spring.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department  department = new Department();
		department.setDeptId(rs.getInt("department_id"));
		department.setDeptName(rs.getString("department_name"));
		return department;
	}

}
