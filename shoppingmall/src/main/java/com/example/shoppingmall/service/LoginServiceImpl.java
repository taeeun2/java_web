package com.example.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dao.LoginDAO;
import com.example.shoppingmall.domain.Member;

@Service 
@Primary 
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public Member login(String id, String pwd)throws Exception{
		return loginDAO.login(id, pwd);
	}

}
