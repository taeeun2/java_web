package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.MemberDAO;

public class MemberListController implements Controller{
	
	private MemberDAO memberDao;
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("../members/MemberList");
		mav.addObject("members",memberDao.selectList());
		return mav;
		//작업을 마친 후 뷰이름을 ModelAndView에 index.jsp로 설정하여 반환
	}
}
