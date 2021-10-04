package pknu.it;

import java.sql.*;

public class JDBCExample {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		
			Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe",
						"DB201712020",
						"201712020");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			
			while(rs.next()) {
				int sno = rs.getInt("sno");
				String sname = rs.getString("sname");
				int year = rs.getInt(3);//1,2,3순서
				String dept = rs.getString(4);
				System.out.format("학번 : %d 이름 : %s 학년 : %d 학과 : %s \n",sno,sname,year,dept);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
	     }
	}
}
