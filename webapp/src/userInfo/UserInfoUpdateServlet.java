package userInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import db.DBAction;
import dto.UserInfo;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		 request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");			 
		 /*
	    Connection conn = DBAction.getInstance().getConnection();
	    PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	

	    request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");			 
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>ȸ������</title></head>");
		out.println("<body><h1>ȸ������</h1>");
		
		try {
			pstmt = conn.prepareStatement("select id,pw,name from userinfo where id = ?");
			pstmt.setString(1, request.getParameter("id"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				out.println("<form action = '/webapp/UserInfoUpdateServlet' method = 'post'>");
				out.println("���̵� : <input type = 'text' name = 'id' value ='"+rs.getString("ID")+"' readonly><br>");//disable : ������ ������ �ȵ�
				out.println("��ȣ : <input type = 'text' name = 'pw' value = '"+rs.getString("PW")+"'><br>");
				out.println("�̸� : <input type = 'text' name = 'name' value = '"+rs.getString("NAME")+"'><br>");
				out.println("<input type = 'submit' value = '����'>");
				out.println("<input type = 'button' value= '���' onclick = 'location.href=\"/webapp/UserInfoListServlet\"'>");
				out.println("<input type = 'button' value= '����' onclick = 'location.href=\"/webapp/UserInfoDeleteServlet?id="+rs.getString("ID")+"\"'>");
				out.println("</form>");
			}
			else {
				out.println("<b>ȸ������ ����</b>");
			}
			out.println("</body></html>");
			out.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/

		try {
			UserInfoDao userinfoDao= new UserInfoDao();
			UserInfo userinfo = userinfoDao.selectOne(request.getParameter("id"));
			request.setAttribute("userinfo", userinfo);
			RequestDispatcher rd = 
			request.getRequestDispatcher("/jspEx/userinfo/UserInfoUpdateForm.jsp");
			rd.include(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*
			Connection conn = DBAction.getInstance().getConnection();
		    PreparedStatement pstmt = null;	
		    
		    request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			try {
				pstmt = conn.prepareStatement("update userinfo set pw = ?, name = ? where id = ?");
				pstmt.setString(1, request.getParameter("pw"));
				pstmt.setString(2, request.getParameter("name"));
				pstmt.setString(3, request.getParameter("id"));

				int result = pstmt.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>ȸ������</title><head><body>");
				out.println(result > -1 ?"<a href = '/webapp/UserInfoListServlet'>ȸ������ ����</a>" : "ȸ������ ����");
				out.println("</body><html>");
				out.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
				if(pstmt !=null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
		}
		*/
		try {
			UserInfoDao userinfoDao = new UserInfoDao();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			
//			List<UserInfo> userinfos = userinfoDao.selectList();
//			for(UserInfo user : userinfos) {
//				if(id.equals(user.getId())) {
//					user.setPw(pw).setName(name);
//					userinfoDao.update(user);
//				}
//			} userinfo DB�� ID�� PK�̱� ������ for���� �������� �ʾƵ� �������.
			
			UserInfo user = new UserInfo().setId(id).setPw(pw).setName(name);
			userinfoDao.update(user);
			
			response.sendRedirect("UserInfoListServlet");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}