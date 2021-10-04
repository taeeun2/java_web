package userInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import dto.UserInfo;

/**
 * Servlet implementation class UserInfoLoginServlet
 */
@WebServlet("/UserInfoLoginServlet")
public class UserInfoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	/*
	 �н� ����
	  	������ �̵�, ������ ����, ���� ����
	  		- forward
	  		- include
	  		- scope(page, request, session, application)
	  		1. page : ������ �ȿ����� ���� ����
	  		2. request : ��ü �ȿ� ���� ����(�Ķ���ͷ� ����)
	  		3. session : �� ��ü�� �Ҹ�� �� ���� ���� ����, �ð����� ����, ������ �޸𸮿� ����
	  		3-1)cookie : Ŭ���̾�Ʈ�� ���� ����
	  		4. application :��� ���ø����̼� ���� ����
	  		
	  		page<request<session<application
	  		
	  		ex)
	  		RequestDispatcher rd = request.getRequestDispatcher("������ ���")
	  		HttpSession session = request.getSession();
	 */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("html/login.html");
		rd.forward(request, response);//�ڿ��� ������ ��
//		response.sendRedirect("/html/login.html"); //���� ������ �̵�

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	Connection conn = null;
		Statement stmt = null;
//		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RequestDispatcher rd1 = request.getRequestDispatcher("HeaderServlet");
		RequestDispatcher rd2 = request.getRequestDispatcher("/error/LoginFail.html");

		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
//			pstmt = conn.prepareStatement("SELECT * FROM USERINFO WHERE ID = ?");
//			pstmt.setString(1, id);
//			pstmt.executeQuery();
			rs = stmt.executeQuery("SELECT * FROM USERINFO WHERE ID = '"+request.getParameter("id")+"'");
			if(rs.next()) {
				if(request.getParameter("pw").equals(rs.getString("pw"))) {
					UserInfo userinfo = new UserInfo().setId(rs.getString("id"))
							.setName(rs.getString("name")).setPw(rs.getString("pw"));
//					ex1)
//					response.setContentType("text/html;charset=UTF-8");
//					PrintWriter out = response.getWriter();
//					out.println("<html><head><title>LoginSuccessFully</title><head>");
//					out.println("<body>�α��� ����!<br>");
//					out.println(userinfo.getName()+"�� �α��� ���Դϴ�.");
//					out.println("</body></html>");

					
//					ex2)
					HttpSession session = request.getSession();
					session.setAttribute("userinfo", userinfo);
//					session.setMaxInactiveInterval(5);
//					response.sendRedirect("UserInfoListServlet");
					
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<html><head><title>LoginSuccessFully</title><head>");
					rd1.include(request, response);
					out.println("<b><br>Service Page</b></html>");
					out.println("</body></html>");
					
				}else {
					rd2.forward(request,response);
				}
			}else {
				rd2.forward(request, response);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//������ ���!
				if(rs != null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		try {
			UserInfoDao userinfoDao = new UserInfoDao();
			UserInfo userinfo = userinfoDao.exist(request.getParameter("id"),request.getParameter("pw"));
			if(userinfo!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", userinfo);
				response.sendRedirect("UserInfoListServlet");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error/LoginFail.html");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
