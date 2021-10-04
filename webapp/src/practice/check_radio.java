package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check_radio")
public class check_radio extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		out.println("<html>");
		out.println("<body>");
		out.println("아이디 : "+id);
		out.println("비밀번호 : "+pw);
		out.println("<br>");//엔터

		
		String receive = request.getParameter("receive");
		if(receive=="y")
			out.println("메일 수신 : O");
		else
			out.println("메일 수신 : X");
		
		out.println("<br>");
		String[] chk1 = request.getParameterValues("chk1");
		out.print("관심 분야 : ");
		if(chk1!=null) {
			for(String chk : chk1) {
				out.print(chk+" ");
			}
		}
		
		out.println("</body>");
		out.println("</html>");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
