package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import bank.DBConnection;

public class DBEx11 {

	/*
	 * DEFAULT
	 * 
	 * DEFAULT 제약 조건은 해당 필드의 기본값을 설정할 수 있게 해줍니다.
	 * 만약 레코드를 입력할 때 해당 필드 값을 전단하지 않으면, 
	 * 자동으로 설정된 기본 값을 저장합니다.
	 * 
	 * [테이블 생성]
	 * 
	 * 		CREATE TABLE TEST6(
	 * 				ID		VARCHAR(10),
	 * 				PW		VARCHAR(30),
	 * 				NAME	VARCHAR(30) DEFAULT 'Anonymous',
	 * 				MDate	DATE,
	 * 				AGE		INT
	 * 		);
	 */
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = insert();
		//	String sql = select();
		//	String sql = create();
		//	String sql = update();
		//	String sql = delete();
			
			stmt.executeUpdate(sql);
			sql = "insert into dbtest2 values('dfr','123')";

			stmt.executeUpdate(sql);
//			rs = stmt.executeQuery(sql);
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int cnt = rsmd.getColumnCount();
//			while(rs.next()) {
//				for(int i=1;i<=cnt;i++) {
//					System.out.print(rs.getString(i)+"\t");
//				}
//				System.out.println();
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			db.close(rs, stmt, conn);
		}
	}
	
	public static String select() {
		String sql = "select * from test5";

		return sql;
	}
	
	public static String insert() {

		String sql = "insert into test6(ID, PW, MDATE, AGE) "
				+ "values('ABC',123,'2021-09-08',100)";
		
		return sql;
	}

	public static String create() {

//		String sql = "CREATE TABLE TEST6(\r\n" + 
//				"	  				ID		VARCHAR(10)," + 
//				"	  				PW		VARCHAR(30)," + 
//				"	  				NAME	VARCHAR(30) DEFAULT 'Anonymous'," + 
//				"	 				MDate	DATE," + 
//				"	 				AGE		INT" + 
//				"	 		)";
		
//		String sql = "CREATE TABLE OBTEST(" + 
//				"NUM INT PRIMARY KEY auto_increment," + 
//				"ID VARCHAR(10))";
//		
		String sql = "create table bwtest(" + 
				"	 	idx int," + 
				"	 	birth date," + 
				"	 	name varchar(10))";
		
		return sql;
		
		
	}
	
	public static String update() {
		String sql = "update test4 set code = 7 where code = 2";
		return sql;
	}
	
	public static String delete() {
		String sql = "delete from test6 where ID='ABC'";
		return sql;
	}
	
}

