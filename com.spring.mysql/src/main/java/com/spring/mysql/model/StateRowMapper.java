package com.spring.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StateRowMapper implements RowMapper<State> {

	@Override
	public State mapRow(ResultSet rs, int rowNum) throws SQLException {
		State state = new State();
		state.setId(rs.getInt("state_id"));
		state.setStateName(rs.getString("state_name"));
		return state;
	}

}
