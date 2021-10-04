package pknu.it;

import java.sql.*;

public class JDBCExample2 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		
			Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe",
						"DB201712020",
						"201712020");
			PreparedStatement stmt = conn.prepareStatement("update student set dept = ? where sno = ?");
			stmt.setString(1,"컴퓨터");
			stmt.setInt(2,100);
			
			int rc = stmt.executeUpdate();//update를 실행했을 때 변경되는 튜플의 개수
			
			System.out.format("%d개의 행이 변경 되었습니다.\n",rc);
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
	     }
	}
}
