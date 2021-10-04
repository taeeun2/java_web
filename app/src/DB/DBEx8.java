package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx8 {

/*
	제약조건(constraint)
	- 제약조건이란 데이터의 무결성을 지키기 위해, 데이터를 입력받을 때 실행되는 검사 규칙을 의미합니다.
	이러한 제약 조건은 create문으로 테이블을 생성할 때나 alter문으로 빌드를 추가할 때도 설정할 수 있습니다.
	
	종류
	1. not null
	2. unique
	3. primary key
	4. foreign key
	5. default
	
 */
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("DB연결 성공!");
			stmt = conn.createStatement();
		// NOT NULL
			String sql = select();
//			int result = stmt.executeUpdate(sql);
//			String msg = result > -1 ? "성공" : "실패";
//			System.out.println(msg);
			//stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
			while(rs.next()) {
				for(int i=1;i<=cnt;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println("Exception : "+e.getMessage());
		}finally {
			try {
				//순서도 기억!
				if(rs != null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	
	}
	/**
	 * DATA INSERT
	 * @return sql
	 */
	
	/*
	 * CREATE TABLE TEST1(
	  		ID VARCHAR(10) NOT NULL,
	  		PW VARCHAR(30),
	  		NAME VARCHAR(30),
	  		MDATE DATE,
	  		AGE INT
	  );
	 */
	
	
	public static String insert() {
		Scanner scan = new Scanner(System.in);
		String sql = "insert into test1(id, pw) values('ABC','123')";
//		String sql = "insert into test1(pw) values('123')";

		return sql;
	}

	/**
	 * DATA SELECT
	 * @return sql
	 */
	public static String select() {
		String sql = "SELECT * FROM TEST1";
		return sql;
	}
}
