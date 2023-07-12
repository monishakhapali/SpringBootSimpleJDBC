package com.spring.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mysql.model.User;
import com.spring.mysql.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public User getUser(String userName)
	{
		return userRepository.getUser(userName);
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.getAllUsers();
	}
	
	public int registerNewUser(User user)
	{
		return userRepository.registerNewUser(user);
	}
	
}
