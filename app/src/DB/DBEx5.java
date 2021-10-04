package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx5 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
			stmt = conn.createStatement();
			String sql = update();
			int result = stmt.executeUpdate(sql);//-1 0 1
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println("Exception : "+e.getMessage());
		}finally {
			try {
				//순서도 기억!
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	
	}
	public static String update() {
		Scanner scan = new Scanner(System.in);
		System.out.print("ID : ");
		String id = scan.next();
		
		System.out.print("PW : ");
		String pw = scan.next();
		
		System.out.print("AGE : ");
		String age = scan.next();
		
		//String sql = "delete from dbtest3 where id='null'";
		//String sql = "insert into dbtest3 values('"+id+"','"+pw+"',"+age+",NOW())";
		String sql = "UPDATE DBTEST3 SET PW='"+pw+"', CRE_DATE=NOW() WHERE ID='"+id+"'";
		return sql;
	}

}
