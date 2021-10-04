package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBEx2 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		//localhost : ip , 3306 : 고정 포트 , app : 데이터베이스명 
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("데이터베이스 드라이버 로딩 성공!");
			//연결 시도
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("데이터베이스 연결 성공!");
		}catch(Exception e) {
			System.out.println("데이터베이스 드라이버 로딩 실패!");
		}
	}

}
