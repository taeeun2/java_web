package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAOImpl;
import dto.Member;

public class LoginAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				String url = "lecture/auth/LoginFail.jsp";
				HttpSession session = request.getSession();
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberDAOImpl memberDAO = MemberDAOImpl.getInstance();
				Member memberVO = null;	
				
				try {
					memberVO = memberDAO.getMember(id);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				if(memberVO!=null) {
					if(memberVO.getPwd().equals(pwd)) {
						session.removeAttribute("id");
						session.setAttribute("loginUser", memberVO);
						url="NonageServlet?command=index";
					}
				}
				request.getRequestDispatcher(url).forward(request, response);
			}
}
