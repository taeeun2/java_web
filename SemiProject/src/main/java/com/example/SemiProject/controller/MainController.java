package com.example.SemiProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;
import com.example.SemiProject.service.DateCourseService;
import com.example.SemiProject.service.UserService;

@Controller
public class MainController {
	/*
	 * @GetMapping("/hello") public void hello(Model model) {
	 * model.addAttribute("greeting", "hi"); }
	 */
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DateCourseService dateCourseservice;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	
/*
	@GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) User loginMember, Model model) {
//       
		try {
		List<User_place> user_place_list = userservice.main_place();
		model.addAttribute("user_place_list",user_place_list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 세션에 회원 데이터가 없으면 홈으로 이동
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

*/
	
	@GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) User loginMember, Model model) {
//       
		
		try {
			
		List<User_place> user_place_list = userservice.main_place();
		if(user_place_list!=null)
			model.addAttribute("user_place_list",user_place_list);
		
	 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 세션에 회원 데이터가 없으면 홈으로 이동
        if (loginMember == null) {
        	model.addAttribute("log","login");
        	
            return "index";
        	//return "index";
        }
        else {
        	model.addAttribute("log","logout");
			model.addAttribute("User", loginMember.getName());
			model.addAttribute("message", "로그인되었습니다.");
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
