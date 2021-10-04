package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserInfo;

/**
 * Servlet implementation class ServletEx7
 */
@WebServlet("/ServletEx7")
public class ServletEx7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx7() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();
		
		Statement stmt = null;
		ResultSet rs = null;
		UserInfo user = null;
		
//		Member member = null; //DTO VO(read only)
		
		out.println("<html>");
		out.println("<body>");
		try {
			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from shopingmall.member where id = '"+id+"'");
//			if(rs.next()) {
//				if(pw.equals(rs.getString("PW"))) {
//					user = new UserInfo().setId(rs.getString("ID"))
//					.setPw(rs.getString("PW")).setName(rs.getString("Name"));
//					
//					out.println("ID : "+user.getId() + ", NAME : "+user.getName());
//					out.println("<br><b>인증되었습니다.</b>");
//				}
//				else {
//					out.println("PW X");
//				}				
//			}else {
//				out.println("ID X");
//			}
			
			rs = stmt.executeQuery("select * from shopingmall.new_pro_view");
			while(rs.next()) {
				out.println(rs.getString("name"));
				out.println(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//순서도 기억!
				if(rs != null) rs.close();
				if(stmt!=null) stmt.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
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
