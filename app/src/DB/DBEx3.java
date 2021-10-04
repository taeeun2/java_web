package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBEx3 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		//localhost : ip , 3306 : 고정 포트 , app : 데이터베이스명 
		Connection conn = null;
		//명령어를 수행시켜주는 객체
		Statement stmt = null;
		try {
			Class.forName(driver);
			System.out.println("데이터베이스 드라이버 로딩 성공!");
			//연결 시도
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("데이터베이스 연결 성공!");
			//명령어
			String sql = "create table DBTEST(ID varchar(10))";
			//varchar : 문자를 저장할 수 있다.
			stmt = conn.createStatement();
			//명령어 실행
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("데이터베이스 드라이버 로딩 실패!");
		}
	}
}
