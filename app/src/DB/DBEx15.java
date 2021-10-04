package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/*
 * order by 문
 		- order by (ASC[ascending], DESC[descending] 정렬)
 		[테이블 생성] : OBTEST
 		CREATE TABLE OBTEST(
 				NUM INT auto_increment,
 				ID VARCHAR(10));
 				
 */
public class DBEx15 {
	public static void main(String[] args) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
//		String sql = insert();
		String sql = orderBy();
		
		try {
			pstmt = conn.prepareStatement(sql);
//			int result = pstmt.executeUpdate();
//			String msg = result > -1 ? "성공" : "실패";
//			System.out.println(msg);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
			for(int i=1;i<=cnt;i++) {
				String columName = rsmd.getColumnName(i);
				System.out.print(columName +"\t");
			}
			System.out.println("\n-------------");
			while(rs.next()) {
				for(int i=1;i<=cnt;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
			
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}
		
	}
	
	
	public static String insert() {
		//String sql = "insert into obtest(id) values('abc')";
		//String sql = "insert into obtest(id) values('def')";
		String sql = "insert into obtest(id) values('ghi')";
		return sql;
	}
	
	public static String orderBy() {
		String sql ="select * from obtest order by num desc";
		return sql;
	}
	

}
