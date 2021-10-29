package com.example.shoppingmall.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.shoppingmall.domain.Member;
import com.example.shoppingmall.domain.Product;
import com.example.shoppingmall.service.ProductService;

@MapperScan(basePackages = "com.example.shoppingmall")
@Controller
public class MainController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String test2(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember,Model model) throws Exception{
		
		//메인 화면에서 new product, best product 보여주기
		List<Product> new_pro_list = productService.new_pro_view();
		List<Product> best_pro_list = productService.best_pro_view();
		
		model.addAttribute("new_pro_list",new_pro_list);
		model.addAttribute("best_pro_list",best_pro_list);
		
		
		//로그인하지 않았을 때
		if (loginMember == null) {
        	model.addAttribute("log","logout");
        	
            return "main";
        }
        else {//로그인을 했을 때
        	model.addAttribute("log","login");
		    model.addAttribute("Member", loginMember.getName());
			model.addAttribute("message", "로그인되었습니다.");
        	return "main";
        }
	}
	
	
}
