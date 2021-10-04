package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx2
 */


/*
 * Instance 생성 : 서블릿 객체 생성
 *  
 * init() : 최초로 한번만 호출
 * 
 */

@WebServlet("/ServletEx2")
public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection conn;

    @Override
    public void init() throws ServletException{
    	
    	String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
		}catch(Exception e) {e.printStackTrace();}	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		

		out.println("<html>");
		out.println("<body>");
		out.println("<table border = '1'>");
		out.println("<tr><td colspan = '1'> 회원 정보 </td></tr>");
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from bank_member";
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<table border = '1'>");
			//tr : row, td : column


			while(rs.next()) {
				out.println("<tr>");
				for(int i=1;i<=columns;i++) {
					out.println("<td>" + rs.getString(i)+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//순서도 기억!
				if(rs != null) rs.close();
				if(stmt!=null) stmt.close();
	
			}catch(SQLException e) {}
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void destroy() {
		try {
			if(conn!=null) {conn.close();}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
