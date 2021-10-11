package com.example.SemiProject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.SemiProject.dao.UserDAO;
import com.example.SemiProject.domain.User;
@Service
@Primary
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User login(Map<String, String> map) throws Exception{
		return userDAO.login(map);
	}
	
	@Override
	public void createUser(Map<String, String> map) throws Exception{
		userDAO.createUser(map);
	}
	
	@Override
	public void editUser(Map<String, String> map) throws Exception{
		userDAO.editUser(map);
	}
	@Override
	public User idCheck(String id)throws Exception{
		return userDAO.idCheck(id);
	}
}
