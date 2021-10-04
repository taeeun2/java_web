package db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBAction {

	private static DBAction instance;
	private Connection conn;
	private DataSource ds;
	public DBAction() {
		/*
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		try {
			InitialContext initctx = new InitialContext();
			Context ctx = (Context)initctx.lookup("java:/comp/env");//이 위치는 변함없음
			ds = (DataSource)ctx.lookup("jdbc/oracle");//이름이 동일해야 한다.
		}catch(NamingException e) {
			e.printStackTrace();
		}
		
	}
	public static DBAction getInstance() {
		if(instance == null) {
			instance = new DBAction();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
