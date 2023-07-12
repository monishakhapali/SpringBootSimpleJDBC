package com.spring.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql.model.User;
import com.spring.mysql.service.UserService;

@RestController
@RequestMapping("v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users/{userName}")
	public User getUserList(@PathVariable("userName") String userName)
	{
		return userService.getUser(userName);
	}
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	 @PostMapping("/registerNewUser")
	    public int registerNewUser(@RequestBody User user) {
	        return userService.registerNewUser(user);
	    }
	

}