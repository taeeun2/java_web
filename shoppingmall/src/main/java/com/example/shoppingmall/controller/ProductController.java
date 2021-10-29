package com.example.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.shoppingmall.domain.Member;
import com.example.shoppingmall.domain.Product;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.ProductService;

@MapperScan(basePackages = "com.example.shoppingmall")
@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	@GetMapping("/view")
	public String view_product(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember,HttpServletRequest request, Model model) throws Exception{
		
		if (loginMember == null) 
        	model.addAttribute("log","logout");
        else {//로그인을 했을 때
        	model.addAttribute("log","login");
		    model.addAttribute("Member", loginMember.getName());
        }
       	
		int kind = Integer.parseInt(request.getParameter("kind"));
		List<Product> product_view_list = productService.product_view(kind);
		model.addAttribute("product_view_list",product_view_list);
		
		return "product";
	}
	
	
	@GetMapping("/view_detail_product")
	public String view_detail_product(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember, HttpServletRequest request, Model model)throws Exception{
		
		
		if (loginMember == null) 
        	model.addAttribute("log","logout");
        else {//로그인을 했을 때
        	model.addAttribute("log","login");
		    model.addAttribute("Member", loginMember.getName());
        	
        }
		
		
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		Product product = productService.product_detail_view(pseq);
		model.addAttribute("product",product);
	
		return "detail_product";
		
	}
	
	
	
}
