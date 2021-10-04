package practice;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import DB.PropertiesEx;

public class DB {
	public static String id, pw, age, date;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		String path = PropertiesEx.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
		//파일 읽어오고 로딩하기
		properties.load(new FileReader(path));
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		id = properties.getProperty("ID");
		pw = properties.getProperty("PW");
		age = properties.getProperty("AGE");
		date = properties.getProperty("DATE");


		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			System.out.println("데이터베이스 드라이버 로딩 성공!");
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("데이터베이스 연결 성공!");
			stmt = conn.createStatement();
			String sql = insert(id, pw, age, date);
			int result = stmt.executeUpdate(sql);//-1 0 1
			//ddl : 0, dcl : 1
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
			
			
		}catch(Exception e) {
			System.out.println("데이터베이스 드라이버 로딩 실패!");
		}finally {
			try {
				//순서도 기억!
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	}
	/*
	 * DATA INSERT
	 * @return sql
	 */
	public static String insert(String id, String pw, String age, String date) {
		System.out.println(id+pw+age+date);
		String sql = "insert into DBTEST3 values('"+id+"','"+pw+"',"+age+",NOW())";		
		return sql;
	}
}
