package com.example.SemiProject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.SemiProject.domain.User;

@Controller
public class MainController {
	/*
	 * @GetMapping("/hello") public void hello(Model model) {
	 * model.addAttribute("greeting", "hi"); }
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	

	@GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) User loginMember, Model model) {
//        // 세션에 회원 데이터가 없으면 홈으로 이동
        if (loginMember == null) {
        	model.addAttribute("log","login");
            return "index";
        	//return "index";
        }
//
//        // 세션이 유지되면 로그인 홈으로 이동
//        model.addAttribute("log","logout");
//        model.addAttribute("User", loginMember.getName());
//        return "index";
//    }
        //return "redirect:/";
		return "index";
	}
	
}
