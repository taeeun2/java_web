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
import org.springframework.web.servlet.ModelAndView;

import com.example.SemiProject.domain.Date_course;
import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;
import com.example.SemiProject.service.DateCourseService;
import com.example.SemiProject.service.UserService;


@MapperScan(basePackages = "com.example.SemiProject")
@Controller
public class Date_courseController {

	
	@Autowired
	UserService userservice;
	
	@Autowired
	DateCourseService dateCourseservice;
	
	@GetMapping("/map")
	public String map() {
		return "map";
	}
	
	@GetMapping("/my_place")
	public String my_place(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(false); 
		User loginMember=(User)session.getAttribute(SessionConstants.LOGIN_MEMBER);
		if(loginMember==null) { 
			return "redirect:/"; 
		} try {
			request.setCharacterEncoding("utf-8"); 
			List<User_place> user_places = userservice.getPlace(loginMember.getId());
			/*
			 * for(User_place user_place : user_places) {
			 * System.out.println(user_place.getPlace_id());
			 * model.addAttribute("user_place", user_place); }
			 * System.out.println(user_places.size());
			 */
			model.addAttribute("user_places", user_places);
			
//			if(user_place==null)
//				System.out.println("null");
//			else {
//				
//				//model.addAttribute(user_place);
			
		 }catch(Exception e) { e.printStackTrace(); }
		return "my_place";
	}
	
	/*
	 * @GetMapping("/my_place") public void my_place(HttpServletRequest request,
	 * Model model) {
	 * 
	 * HttpSession session = request.getSession(false); User loginMember
	 * =(User)session.getAttribute(SessionConstants.LOGIN_MEMBER);
	 * if(loginMember==null) { //return "index"; } try {
	 * request.setCharacterEncoding("utf-8"); User_place user_place =
	 * userservice.idCheck2(loginMember.getId());
	 * 
	 * model.addAttribute(user_place);
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * //return "my_place"; }
	 */
	
	@PostMapping("/save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false); 
		User loginMember =(User)session.getAttribute(SessionConstants.LOGIN_MEMBER);
		if(loginMember==null) {
			System.out.println("로그인이 되지 않았습니다.");
		
		}
		try {
			 request.setCharacterEncoding("utf-8");
			 response.setContentType("text/html; charset=utf-8");
		
			 PrintWriter out = response.getWriter();
			 String place_id = request.getParameter("place_id");
			 String total_distance = request.getParameter("total_distance");
			 String[] place_name =request.getParameterValues("place_name");
			 String[] place_address = request.getParameterValues("place_address");
			 
			 Map<String, String> map = new HashMap<>();
			 map.put("place_id", place_id);
			 map.put("total_distance", total_distance);
			 map.put("user_id", loginMember.getId());
			 
			 userservice.insertUserPlace(map);
			 
			 
			 for(int i=0;i<place_name.length;i++) {
				dateCourseservice.insertDateCourse(place_id, place_name[i], place_address[i], i);
	
			 }
		 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	
	
	@GetMapping("/detail_place")
	public String detail_place(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("place_id");
		List<Date_course> date_course_list = dateCourseservice.getDateCourse(id);
		model.addAttribute("date_course_list", date_course_list);
		model.addAttribute("place_id", id);
		return "detail_place";
	}
	
	
	@GetMapping("/update_date_course")
	public ModelAndView update_date_course(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));	
		Date_course date_course = dateCourseservice.getOneDateCourse(num);
		
		String place_id = request.getParameter("place_id");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject(date_course);
		//mav.addObject(place_id);
		mav.setViewName("update_date_course");
		return mav;
	}
	

	
	
	
	
}
