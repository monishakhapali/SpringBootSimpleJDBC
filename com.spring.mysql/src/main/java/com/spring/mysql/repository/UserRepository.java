package com.spring.mysql.repository;


import java.sql.Types;
import java.util.List;
//import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
//import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mysql.model.Role;
import com.spring.mysql.model.User;
import com.spring.mysql.model.UserRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.spring.mysql.model.RoleRowMapper;
//import org.springframework.jdbc.core.SqlParameter;

@Transactional
@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getUser(String userName)
	{
		
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		
		SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GetUsersData");
		
		SqlParameterSource inParams = new MapSqlParameterSource().addValue("user_name", userName);
		System.out.println(inParams);
		Map<String, Object> out = executor.execute(inParams);
		
		User user = new User();
		//System.out.println(outParams.get("user_firstname").toString());
		user.setId((int) out.get("user_id"));
		user.setUsername(userName);
		user.setUserfirstname(out.get("user_firstname").toString());
		user.setUserlastname(out.get("user_lastname").toString());
		user.setPassword(out.get("user_password").toString());
		
		String sql = "select r.roleid,r.rolename,r.roledescription from users u\r\n"
				+ "				inner join userrole ur \r\n"
				+ "				on u.id=ur.userid \r\n"
				+ "				inner join roles r\r\n"
				+ "				on r.roleid=ur.roleid\r\n"
				+ "where u.username =" + userName;
		
		RowMapper<Role> rowMapper = new RoleRowMapper();
		
		user.setRoles(this.jdbcTemplate.query(sql, rowMapper)); 
		
		return user;
		
		
	}
	
	public List<User> getAllUsers() {
		String sql = "select u.username,u.userfirstname,u.userlastname,u.password,r.roleid,r.rolename,r.roledescription from users u\r\n"
				+ "inner join userrole ur \r\n"
				+ "on u.id=ur.userid \r\n"
				+ "inner join roles r\r\n"
				+ "on r.roleid=ur.roleid";
		// RowMapper<Article> rowMapper = new
		// BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	  }
	
	 
	  public int registerNewUser(User user) {
		
		  jdbcTemplate.setResultsMapCaseInsensitive(true);
				
		  SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
	                .withProcedureName("AddUserData");
		  executor.addDeclaredParameter(new SqlParameter("user_name", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("user_firstname", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("user_lastname", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("user_password", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("role_name", Types.VARCHAR));
		  
		  MapSqlParameterSource inParams = new MapSqlParameterSource();
		  inParams.addValue("user_name", user.getUsername());
		  inParams.addValue("user_firstname", user.getUserfirstname());
		  inParams.addValue("user_lastname", user.getUserlastname());
		  inParams.addValue("user_password", user.getPassword());
		  
		  Map<String, Object> out = executor.execute(inParams);
		  AddUserRole(user.getRoles(),user.getUsername());
		  
		 return (int)out.get("user_id");
		  
		  
	  }
	  
	  public void AddUserRole(List<Role> roles, String userName)
	  {
		  jdbcTemplate.setResultsMapCaseInsensitive(true);
			
		  SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
	                .withProcedureName("AddUserRoleData");
		  
		  executor.addDeclaredParameter(new SqlParameter("role_name", Types.VARCHAR));
		  executor.addDeclaredParameter(new SqlParameter("user_name", Types.VARCHAR));
		  MapSqlParameterSource inParams = new MapSqlParameterSource();
		  inParams.addValue("user_name", userName);
		  for(Role role : roles)
		  {
			  inParams.addValue("role_name", role.getRoleName());
			  executor.execute(inParams);
		  }
		  
		}

}
