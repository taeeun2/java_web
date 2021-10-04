package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBEx17 {
/*
 * ex1) NOW, SYSDATE : ���� �ð�, ��¥ ���� ���
 * ex2) CURDATE, CURENTDATE : ���� ��¥ ���� ���
 * ex3) CURTIME, CURENTTIME : ���� �ð� ���� ���
 * 
 */
	public static void main(String[] args) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
//		String sql = insert();
		String sql = select();
		
		try {
			pstmt = conn.prepareStatement(sql);
//			int result = pstmt.executeUpdate();
//			String msg = result > -1 ? "����" : "����";
//			System.out.println(msg);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
			for(int i=1;i<=cnt;i++) {
				String columName = rsmd.getColumnName(i);
				System.out.print(columName +"\t");
			}
			System.out.println("\n-----------------------------");
			while(rs.next()) {
				for(int i=1;i<=cnt;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
			
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}
	}
	public static String select() {
//		ex1) now, sysdate : ����ð�, ��¥���� ���
//		String sql = "select sysdate() sysdate, now() now";
//		ex2) curdate, current_date : ���� ��¥���� ���
//		String sql = "select curdate() curdate, current_date() currentdate";
//		ex3) curtime, current_time : ���� �ð����� ���
		String sql = "select curtime() curtime, current_time() currenttime";
		return sql;
	}
	
	
	

}
