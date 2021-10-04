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
			stmt.setString(1,"��ǻ��");
			stmt.setInt(2,100);
			
			int rc = stmt.executeUpdate();//update�� �������� �� ����Ǵ� Ʃ���� ����
			
			System.out.format("%d���� ���� ���� �Ǿ����ϴ�.\n",rc);
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
	     }
	}
}
