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
		//���� �о���� �ε��ϱ�
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
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("�����ͺ��̽� ���� ����!");
			stmt = conn.createStatement();
			String sql = insert(id, pw, age, date);
			int result = stmt.executeUpdate(sql);//-1 0 1
			//ddl : 0, dcl : 1
			String msg = result > -1 ? "����" : "����";
			System.out.println(msg);
			
			
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
		}finally {
			try {
				//������ ���!
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
