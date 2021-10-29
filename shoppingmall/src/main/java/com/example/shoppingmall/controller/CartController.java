package com.example.shoppingmall.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.shoppingmall.domain.AddressVO;
import com.example.shoppingmall.domain.Member;
import com.example.shoppingmall.domain.Product;
import com.example.shoppingmall.service.AddressService;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
//	@Autowired
//	OrderService orderService;
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/cart_product")//장바구니에 물건 담기
	public String cart_product(int pseq, int quantity, @SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember,Model model ) throws Exception {
		
		
		if (loginMember == null) {
			model.addAttribute("log","logout");
			return "login";
		}
		
		Product product = productService.product_detail_view(pseq);
		model.addAttribute("product",product);
		
		
	    model.addAttribute("log","login"); 
	    model.addAttribute("Member",loginMember.getName()); 
	    //장바구니에 담기
	    
	    //장바구니에 동일한 상품이 있는지 확인
	    Product product_cart = cartService.cart_pseq(loginMember.getId(), pseq);
	    
	    if(product_cart==null)
	    	cartService.insert_cart(loginMember.getId(), pseq, quantity);
	    else
	    	cartService.update_cart(quantity, pseq);
	    
	  
	    model.addAttribute("product_name", product.getName());
	    model.addAttribute("quantity",quantity);
	    model.addAttribute("message2","개가 장바구니에 담겼습니다.");
	  
	  return "detail_product";
		 
	}
	
	
//	@GetMapping("/cart")//장바구니
//	public void cartView(Model model,@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember) throws Exception{
//		
//		model.addAttribute("log","login");
//		model.addAttribute("Member",loginMember.getName());
//		
//		int[] pseq_list = cartService.select_cart_pseq(loginMember.getId());
//		if(pseq_list != null) {
//			List<Product> product_list = new ArrayList<>();
//			for(int pseq : pseq_list) {
//				Product product = productService.product_detail_view(pseq);
//				product.setQuantity(cartService.select_cart_quantity(pseq));
//				product_list.add(product);
//			}
//			model.addAttribute("product_list", product_list);
//		}
//		else
//		{
//			System.out.println("장바구니에 물건이 없습니다.");
//		}
//	}
//	
	
	@GetMapping("/cart")//장바구니
	public String cartView(Model model,@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember) throws Exception{
		
		
		if(loginMember==null) {
			model.addAttribute("log","logout");
			return "login";
		}
		
		
		model.addAttribute("log","login");
		model.addAttribute("Member",loginMember.getName());
		
		int[] pseq_list = cartService.select_cart_pseq(loginMember.getId());
		if(pseq_list != null) {
			List<Product> product_list = new ArrayList<>();
			for(int pseq : pseq_list) {
				Product product = productService.product_detail_view(pseq);
				product.setQuantity(cartService.select_cart_quantity(pseq));
				product_list.add(product);
			}
			model.addAttribute("product_list", product_list);
			return "cart";
		}
		else
		{
			System.out.println("장바구니에 물건이 없습니다.");
			return "cart";
		}
	}
	
	List<Product> order_list = new ArrayList<>();


	@PostMapping("/order")//주문하기
	public ModelAndView order(Model model,@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember, HttpServletRequest request) throws Exception{
		//체크된 상품들 가져오기
		String[] product_num_list = request.getParameterValues("chbox");
//		//주문 테이블
//		orderService.make_order(loginMember.getId());
//		
//		//주문 번호 가져오기
//		int oseq = orderService.get_oseq(loginMember.getId());
		
		for(String product_num : product_num_list) {
			int product_num2 = Integer.parseInt(product_num);
			Product product = productService.product_detail_view(product_num2);
			product.setQuantity(cartService.select_cart_quantity(product_num2));
			order_list.add(product);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("log","login");
		mav.addObject("Member",loginMember.getName());
		mav.setViewName("order");
		return mav;

	}
	
	
	@GetMapping("/order")
	public void orderView(Model model,@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember ) {
		model.addAttribute("order_list",order_list);
		model.addAttribute("log","login");
		model.addAttribute("Member",loginMember.getName());
	}

	@GetMapping("/post")
	public void postView() {
		
	}
	
	@PostMapping("/post")
	 public void post(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		 
		 try {
			 request.setCharacterEncoding("utf-8");
			 response.setContentType("text/html; charset=utf-8");
		
			 PrintWriter out = response.getWriter();
			 String dong = (String)request.getParameter("dong");
			 List<AddressVO> addressList = addressService.getAddress(dong);
			 model.addAttribute("list",addressList);
			 model.addAttribute("test","test");
			 
			 ObjectMapper mapper = new ObjectMapper();
			 
			 out.print(mapper.writeValueAsString(addressList));
			 
		 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	@GetMapping("/kakao")
	public String kakao() {
		return "Kakaopay";
	}
	
	
}
