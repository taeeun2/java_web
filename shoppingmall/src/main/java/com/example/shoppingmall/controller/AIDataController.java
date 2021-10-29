package com.example.shoppingmall.controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.domain.Member;
import com.example.shoppingmall.service.LoginService;


@MapperScan(basePackages = "com.example.shoppingmall")
@RestController
public class AIDataController {

	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public ResponseEntity<Member> login(String id) {
		try {
			System.out.print("들어옴");
			Member member = loginService.login(id, "123");
			return new ResponseEntity<>(member,HttpStatus.BAD_REQUEST.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/audioTest")
	public void audioTest() {
		
	}
	

	@GetMapping("/test")
	public void test() {
		
	}
	
}
