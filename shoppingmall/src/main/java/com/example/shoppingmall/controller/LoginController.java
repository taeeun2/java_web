package com.example.shoppingmall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.shoppingmall.domain.Member;
import com.example.shoppingmall.service.LoginService;



@MapperScan(basePackages = "com.example.shoppingmall")
@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public void loginView(Model model) {
		//따로 리턴값을 주지 않아도 login.html로 이동한다
		model.addAttribute("log","logout");
	}
	
	/*
	@PostMapping("/login")
	public String login(String id, String pwd, Model model, HttpServletRequest request) throws Exception{
		
		Member member = loginService.login(id, pwd);
	
		if(member==null) {
			model.addAttribute("log","logout");
			model.addAttribute("message","아이디 또는 비밀번호가 일치하지 않습니다.");
			return "/login";
		}
		model.addAttribute("log","login");
		HttpSession session = request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
		session.setAttribute(SessionConstants.LOGIN_MEMBER, member);//세션에 로그인 회원 정보 보관
		model.addAttribute("Member", member.getName());
		return "redirect:/";
		
	}*/
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model)throws Exception{
		
		 model.addAttribute("log","logout");
		 HttpSession session = request.getSession(false);
		    if (session != null) {
		        session.invalidate();   // 세션 날림
		    }

		    return "redirect:";
	}
	
}
