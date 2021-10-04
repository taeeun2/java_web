package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx6 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
			stmt = conn.createStatement();
			
			System.out.print("menuNum : ");
			int menuNum = scan.nextInt();
			String sql = "";
			switch(menuNum) {
					case 1:
						sql = delete();
						break;
					case 2:
						sql = insert();
						break;
					case 3:
						sql = update();
						break;
					case 4:
						sql = insert2();
						break;
					case 5:
						sql = select();
						rs = stmt.executeQuery(sql);

						String id = rs.getString("ID");
						System.out.println("ID : "+id);

						String pw = rs.getString("PW");
						System.out.println("PW : "+pw);

						String age = rs.getString("AGE");
						System.out.println("AGE : "+age);
							
						String date = rs.getString("CRE_DATE");
						System.out.println("DATE : "+date);
						
						break;
						
					case 6:
						sql=select_all();						
						rs = stmt.executeQuery(sql);
						ResultSetMetaData rsmd = rs.getMetaData();
						int colums = rsmd.getColumnCount();
						while(rs.next()) {
							for(int i=1;i<=colums;i++) {
								System.out.println(rs.getString(i)+"\t");
							}
							
							System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						}
					
			}

//			int result = stmt.executeUpdate(sql);//-1 0 1
//			String msg = result > -1 ? "성공" : "실패";
//			System.out.println(msg);
//			
			
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
	
	public static String delete() {
		System.out.print("ID : ");
		String id = scan.next();

		System.out.print("PW : ");
		String pw = scan.next();
		String sql = "delete from dbtest3 where ID = '"+id+"'&& PW='"+pw+"'";
		return sql;
	}
	
	public static String insert() {
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		System.out.print("AGE : ");
		String age = scan.next();
		
		
		String sql = "insert into dbtest3 values('"+id+"','"+pw+"','"+age+"',NOW())";
		return sql;
	}
	
	public static String update() {
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		String sql = "UPDATE DBTEST3 SET PW = '"+pw+"' WHERE ID = '"+id+"'";
		return sql;
	}
	
	public static String insert2() {
		System.out.print("ID : ");
		String id = scan.next();

		String sql = "insert into dbtest values('"+id+"')";
		return sql;
	}
	public static String select_all() {
		String sql = "select * from DBTEST3";
		return sql;
	}
	
	public static String select() {
		Scanner scan = new Scanner(System.in);
		System.out.print("ID : ");
		String id = scan.next();
		String sql = "select * from DBTEST3 where ID = '"+id+"'";
		return sql;
	}
	
	
}


