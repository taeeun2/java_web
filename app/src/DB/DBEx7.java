package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx7 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("DB연결 성공!");
			stmt = conn.createStatement();
			String sql = select();
			rs = stmt.executeQuery(sql);
			UserData userdata;
			
			while(rs.next()) {

				String id = rs.getString("ID");
				System.out.println("ID : "+id);

				String pw = rs.getString("PW");
				System.out.println("PW : "+pw);

				int age = rs.getInt("AGE");
				System.out.println("AGE : "+age);
				
				String date = rs.getString("CRE_DATE");
				System.out.println("DATE : "+date);
				
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				
				userdata = new UserData();
				userdata.setId(id);
				userdata.setPw(pw);
				userdata.setAge(age);
				userdata.setDate(date);
				

//				String pw = rs.getString("PW");
//				int age = rs.getInt("AGE");
			}
		
			
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println("Exception : "+e.getMessage());
		}finally {
			try {
				//순서도 기억!
				if(rs != null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	
	}
	
	public static String select() {
		Scanner scan = new Scanner(System.in);
		System.out.print("ID : ");
		String id = scan.next();
		String sql = "select * from DBTEST3 where ID = '"+id+"'";
		return sql;
	}

}

class UserData{
	String id,pw,date;
	int age;
	public UserData() {
		
	}

	public UserData(String id, String pw, String date, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.date = date;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
