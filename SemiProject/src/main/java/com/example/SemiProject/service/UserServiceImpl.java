package com.example.SemiProject.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.SemiProject.dao.UserDAO;
import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;
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
	
	@Override
	public User_place idCheck2(String id)throws Exception{
		return userDAO.idCheck2(id);
	}
	
	@Override
	public void insertUserPlace(Map<String, String> map)throws Exception{
		userDAO.insertUserPlace(map);
	}
	
	@Override
	public List<User_place> getPlace(String id) throws Exception{
		return userDAO.getPlace(id);
		
	}
}
