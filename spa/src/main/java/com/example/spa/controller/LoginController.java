package com.example.spa.controller;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spa.domain.UserTBL;
import com.example.spa.mapper.UserTBLMapper;
import com.fasterxml.jackson.databind.ObjectMapper;





@Controller
@MapperScan(basePackages = "com.example.spa")
public class LoginController {
	
	@RequestMapping("/")
	public String test(Model model) {
		model.addAttribute("message","주목받는 AI 웹 9대 핵심 기술 분석");
		return "test1";
	}
	
	@Autowired
	UserTBLMapper mapper;
	
	
	@PostMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			
			
			PrintWriter out = response.getWriter();
			String id = (String)request.getParameter("id");
			String pw = (String)request.getParameter("pw");
			
			System.out.println(id+"+"+pw);
			Map<String, String> map = new HashMap<>();
			map.put("id",id);
			map.put("pw", pw);
			UserTBL findUser = mapper.getLoginInfo(map);
			
			ObjectMapper mapper = new ObjectMapper();
			
			if(findUser!=null) {
				out.print(mapper.writeValueAsString(findUser));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		

		}
	}
}
