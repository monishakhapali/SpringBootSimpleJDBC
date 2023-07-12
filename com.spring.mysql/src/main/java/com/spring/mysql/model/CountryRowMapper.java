package com.spring.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		country.setCountryId(rs.getInt("country_id"));
		country.setCountryName(rs.getString("country_name"));
		return country;
	}

}
