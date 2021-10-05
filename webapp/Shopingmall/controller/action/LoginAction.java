package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class LoginAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
//				String url = "lecture/login_fail.jsp";
//				HttpSession session = request.getSession();
//				String id = request.getParameter("id");
//				String pwd = request.getParameter("pwd");
//				MemberDAO memberDAO = MemberDAO.getInstance();
//				MemberVO memberVO = null;	
//				
//				try {
//					memberVO = memberDAO.getMember(id);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//				
//				if(memberVO!=null) {
//					if(memberVO.getPwd().equeals(pwd)) {
//						session.removeAttribute("id");
//						session.setAttribute("loginUser", memberVO);
//						url="NonageServlet?command=index";
//					}
//				}
//				request.getRequestDispatcher(url).forward(request, response);
			}
}
