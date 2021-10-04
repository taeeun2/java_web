package userInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;


@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HeaderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
//		session.setMaxInactiveInterval(3*60);//������ ����Ǹ� ���� �Ҹ�(3��)
		UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
		//�α����� ���� ��, userinfo�� null�� �ƴϴ�.
		if(userinfo != null) {
			out.println(userinfo.getName()+"�� �α��� ���Դϴ�.");
			out.println("<input type = 'button' value = '�α׾ƿ�' "
					+ " onclick = 'location.href=\"/webapp/UserInfoLogOutServlet\"'>");
		}
		else {
			out.println("session���� ����<br>");
			out.println("<input type = 'button' value = '�α���'"
					+" onclick = 'location.href = \"/webapp/html/login.html\"'>");
		}
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
