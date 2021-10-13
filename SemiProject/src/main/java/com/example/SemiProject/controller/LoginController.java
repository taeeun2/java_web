package com.example.SemiProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;
import com.example.SemiProject.service.UserService;

@MapperScan(basePackages = "com.example.SemiProject")
@Controller
//@RestController
public class LoginController {

	@Autowired
	UserService userservice;
////	
//	@Autowired
//	private UserMapper mapper;
	
	@GetMapping("/login")
	public void loginView() {
		
	}
	@PostMapping("/login")
	public String login(String id, String pwd, Model model, HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd",pwd);
		
		
		try {
			User findUser = userservice.login(map);
			if(findUser==null||id.trim()==""||pwd.trim()=="") {
				model.addAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return "login";
			}
			List<User_place> user_place_list = userservice.main_place();
			if(user_place_list!=null)
				model.addAttribute("user_place_list",user_place_list);
			
			model.addAttribute("log","logout");
			model.addAttribute("message", "로그인되었습니다.");
			HttpSession session = request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
			session.setAttribute(SessionConstants.LOGIN_MEMBER, findUser);//세션에 로그인 회원 정보 보관
			model.addAttribute("User", findUser.getName());
			return "index";
//		User findUser = mapper.getLoginInfo(map);
//		if(findUser!=null) {
//			model.addAttribute("message", "로그인되었습니다.");
//			HttpSession session = request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
//			session.setAttribute(SessionConstants.LOGIN_MEMBER, findUser);//세션에 로그인 회원 정보 보관
//			
//			return "redirect:";
//			
//		}
//		else
//			model.addAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
//			return "login";
////			return "redirect:login";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
//			return "redirect:login";
			
//			return "forward:error";
		}
	}
	
//	@PostMapping("/logout")
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();   // 세션 날림
	    }

	    return "redirect:";
	}
	
	
	
}
