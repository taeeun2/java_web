package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx9 {

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
		// UNIQUE, PRIMARY KEY
			String sql = insert();
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
//			stmt.execute(sql);
			
//			rs = stmt.executeQuery(sql);
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int cnt = rsmd.getColumnCount();
//			while(rs.next()) {
//				for(int i=1;i<=cnt;i++) {
//					System.out.print(rs.getString(i)+"\t");
//				}
//				System.out.println();
//			}
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
	/*
	 * primary key = not null, unique
	 */
	public static String create() {
		String sql = "create table test3(ID VARCHAR(10) PRIMARY KEY, PW VARCHAR(30), "
				+ "NAME VARCHAR(30), MDate DATE, AGE INT)";
		return sql;
	
	}
	
	public static String insert() {
		Scanner scan = new Scanner(System.in);
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		
		String sql = "insert into test3(id, pw) values('"+id+"','"+pw+"')";
//		String sql = "insert into test1(pw) values('123')";

		return sql;
	}

	/**
	 * DATA SELECT
	 * @return sql
	 */
	public static String select() {
		String sql = "SELECT * FROM TEST2";
		return sql;
	}

}
