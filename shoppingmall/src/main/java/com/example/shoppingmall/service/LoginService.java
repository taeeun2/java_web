package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Member;

public interface LoginService {
	public Member login(String id, String pwd)throws Exception;
}
