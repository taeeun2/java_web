package com.example.SemiProject.service;

import java.util.Map;

import com.example.SemiProject.domain.User;

public interface UserService {

	public User login(Map<String, String> map) throws Exception;
	public void createUser(Map<String, String> map) throws Exception;
	public void editUser(Map<String, String> map) throws Exception;
	public User idCheck(String id)throws Exception;
}
