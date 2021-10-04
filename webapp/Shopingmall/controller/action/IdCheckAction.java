package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAOImpl;


public class IdCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		MemberDAOImpl memberDAO = MemberDAOImpl.getInstance();
		boolean overlappedID = memberDAO.overlappedID(id);
		
		if(overlappedID == true) {
			out.print("not_usable");
		}else {
			out.print("usable");
		}
	}
}
