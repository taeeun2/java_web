package com.example.SemiProject.service;

import java.util.List;
import java.util.Map;

import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;

public interface UserService {

	public User login(Map<String, String> map) throws Exception;
	public void createUser(Map<String, String> map) throws Exception;
	public void editUser(Map<String, String> map) throws Exception;
	public User idCheck(String id)throws Exception;
	public User_place idCheck2(String id)throws Exception;
	public void insertUserPlace(Map<String, String> map)throws Exception;
	public List<User_place> getPlace(String id)throws Exception;
}
