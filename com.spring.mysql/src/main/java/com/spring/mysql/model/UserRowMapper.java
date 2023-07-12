package com.spring.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setUserfirstname(rs.getString("userfirstname"));
		user.setUserlastname(rs.getString("userlastname").toString());
		user.setPassword(rs.getString("password").toString());
		return user;
	}
	
}
