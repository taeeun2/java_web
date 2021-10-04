package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAOImpl;
import dto.Member;

public class JoinAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		String url = "member/login.jsp";
		HttpSession session = request.getSession();
		Member memberVO = new Member();		
		MemberDAOImpl memberDAO = MemberDAOImpl.getInstance();
		try {
			
			memberVO.setId(request.getParameter("id"));
			memberVO.setPwd(request.getParameter("pwd"));
			memberVO.setName(request.getParameter("name"));
			memberVO.setEmail(request.getParameter("email"));
			memberVO.setZip_num(request.getParameter("post"));
			memberVO.setAddress(request.getParameter("address"));
			memberVO.setPhone(request.getParameter("phone"));
			memberDAO.insertMember(memberVO);
			session.setAttribute("loginUser", memberVO);
			url = "NonageServlet?command=index";
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
