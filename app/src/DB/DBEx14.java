package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBEx14 {

//*ALTER��
//  - TABLE ����
/* [���̺� ����] : ATTEST

	String sql = "create table attest("+
				"id varchar(10) not null,"+
				"pw varchar(10))";
				
	�ǽ�1) ���̺� ���ο� �÷� �߰�
	�ǽ�2) ���̺��� �÷� Ÿ�� ����
	�ǽ�3) ���̺��� �÷� �̸� ����
 	�ǽ�4) ���̺� �÷� ����
 
 
 */

	public static void main(String[] args) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = alter();
		try {
			pstmt = conn.prepareStatement(sql);
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "����" : "����";
			System.out.println(msg);
			
			
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}
		
	}

	public static String alter() {
//		String sql = "ALTER TABLE ATTEST ADD COLUMN AGE VARCHAR(10) NOT NULL ";
//		String sql = "ALTER TABLE ATTEST MODIFY COLUMN AGE INT";
//		String sql = "ALTER TABLE ATTEST CHANGE COLUMN PW PASSWORD VARCHAR(30) NOT NULL";
		String sql = "ALTER TABLE ATTEST DROP COLUMN AGE";
		
		return sql;
	}
	
}
