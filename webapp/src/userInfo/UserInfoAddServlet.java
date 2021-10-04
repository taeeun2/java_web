package userInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import dto.UserInfo;

/**
 * Servlet implementation class UserInfoAddServlet
 */
@WebServlet("/UserInfoAddServlet")
public class UserInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


 
    /*@Override
    public void init() throws ServletException{
    	
    	String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
		}catch(Exception e) {e.printStackTrace();}	
    	
    }
    */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*PrintWriter out = response.getWriter();
		out.println("<html><head><title>ȸ�� ���</title></head>");
		out.println("<body><h1>ȸ�� ���</h1>");
		out.println("<form action = '/webapp/UserInfoAddServlet' method = 'post'>");
		
		//post�� �� ������ form�±׸� Ȱ���Ͽ� ���� �����͸� �ѹ��� �ѱ� �� �־�� �Ѵ�.
		out.println("���̵� : <input type = 'text' name = 'id'><br>");
		out.println("��й�ȣ : <input type = 'password' name = 'pw'><br>");
		out.println("�̸� : <input type = 'text' name = 'name'><br>");
		out.println("�̸��� : <input type = 'text' name = 'name'><br>");
		
		out.println("<input type = 'submit' value = '�߰�'>");
		out.println("<input type = 'reset' value = '���'>");
		out.println("</form");
		out.println("</body></html>");
		out.close();
		*/
		RequestDispatcher rd = request.getRequestDispatcher("/jspEx/MemberForm.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		//null, ���� üũ���ֱ�
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		UserInfo user = new UserInfo().setId(id).setPw(pw).setName(name);
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			stmt = conn.createStatement();
//			pstmt = conn.prepareStatement("insert into bank_member values(?,?,?)");
//			pstmt.setString(1,user.getId());
//			
			
			int result = stmt.executeUpdate("insert into userinfo values('"+user.getId()+"','"+user.getPw()+"','"+user.getName()+"')");
			out.println(result > -1 ? "<a href='/webapp/UserInfoListServlet'>ȸ������ ����</a>" : "���� ����");
			out.println();
			out.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//������ ���!
			
				if(stmt!=null) stmt.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
*/
		
		try {
			UserInfoDao userinfoDao = new UserInfoDao();
			String id = request.getParameter("id");
			String pw = request.getParameter("pwd");
			String name = request.getParameter("name");
			UserInfo user = new UserInfo().setId(id).setPw(pw).setName(name);
			userinfoDao.insert(user);
			response.sendRedirect("UserInfoListServlet");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	@Override
	public void destroy() {
		try {
			if(conn!=null) 
			{conn.close();}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/

}
