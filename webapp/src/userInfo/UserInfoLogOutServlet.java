package userInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserInfoLogOutServlet")
public class UserInfoLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserInfoLogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();//���� ���� �Ҹ�
//		session.getId();//���� ���̵� ���� ����
//		session.removeAttribute("userinfo");//���� ������ �ʿ��� �͸� ���� �� ����
		response.sendRedirect("auth/LogInForm.jsp");
//		response.sendRedirect("UserInfoLoginServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
