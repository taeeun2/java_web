package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBEx12 {

	public DBEx12() {
		DBAction db = DBAction.getInstance();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql = "select * from test6";
		try {
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			while(rs.next()) {
				for(int i=1;i<=cols;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}
		}
	
	}
	public static void main(String args[]) {
		new DBEx12();
	}
	
	
}

