package com.spring.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setRoleId(rs.getInt("roleid"));
		role.setRoleName(rs.getString("rolename"));
		role.setRoleDescription(rs.getString("roledescription").toString());
		return role;
	}

}
