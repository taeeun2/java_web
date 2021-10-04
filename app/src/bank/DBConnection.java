package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import DB.DBAction;

public class DBConnection {
	
	
	private static DBConnection instance = new DBConnection();
	private Connection conn;
	public DBConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void close(ResultSet rs,  Statement stmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
