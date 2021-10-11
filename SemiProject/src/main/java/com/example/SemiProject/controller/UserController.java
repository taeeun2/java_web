package com.example.SemiProject.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SemiProject.domain.AddressVO;
import com.example.SemiProject.domain.User;
import com.example.SemiProject.mapper.AddressMapper;
import com.example.SemiProject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@MapperScan(basePackages = "com.example.SemiProject")
@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/join")
	public String join(User user) {
		Map<String, String> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("pwd", user.getPwd());
		map.put("email", user.getEmail());
		map.put("address", user.getAddress()+" "+user.getDetail_address());
		map.put("phone", user.getPhone());
		map.put("zip_num", user.getZip_num());
		map.put("name", user.getName());
		
		try {
			userservice.createUser(map);
			return "login";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/edit")
	public void edit(HttpServletRequest request, Model model,User user) {

		HttpSession session = request.getSession(false);
	    if (session == null) {
	        System.out.println("null");
	    }
	    else {
	    User loginMember =(User)session.getAttribute(SessionConstants.LOGIN_MEMBER);
	    model.addAttribute("id", loginMember.getId());
		model.addAttribute("pwd", loginMember.getPwd());
		model.addAttribute("email", loginMember.getEmail());
		model.addAttribute("address", loginMember.getAddress());
		model.addAttribute("phone", loginMember.getPhone());
		model.addAttribute("zip_num", loginMember.getZip_num());
		model.addAttribute("name", loginMember.getName());
	    }
	}
	
	@PostMapping("/edit")
	public String edit(User user) {
		
		Map<String, String> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("pwd", user.getPwd());
		map.put("email", user.getEmail());
		map.put("address", user.getAddress());
		map.put("phone", user.getPhone());
		map.put("zip_num", user.getZip_num());
		map.put("name", user.getName());
		
		try {
			userservice.editUser(map);
			return "login";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	 @ResponseBody
	 @RequestMapping(value="/idCheck", method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
	public int idCheck(@RequestBody String id) {
		int count = 0;

		try {
			if(userservice.idCheck(id)!=null) {
				count=1;
			}
			else {
				count=2;
			}
				
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return count;
	}
	 
	 @Autowired
	 AddressMapper mapper;
	
//	 @ResponseBody
//	 @RequestMapping(value="/post", method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
	 @PostMapping("/post")
	 public void post(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		 
		 try {
			 request.setCharacterEncoding("utf-8");
			 response.setContentType("text/html; charset=utf-8");
		
			 PrintWriter out = response.getWriter();
			 String dong = (String)request.getParameter("dong");
			 List<AddressVO> addressList = mapper.getAddress(dong);
			 model.addAttribute("list",addressList);
			 model.addAttribute("test","test");
			 
			 ObjectMapper mapper = new ObjectMapper();
			 
			 out.print(mapper.writeValueAsString(addressList));
			 
		 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	
}
