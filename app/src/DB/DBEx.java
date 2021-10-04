package DB;

public class DBEx {

	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			System.out.println("데이터 베이스 드라이버 로딩 성공!");
		}catch(Exception e) {
			System.out.println("데이터 베이스 드라이버 로딩 실패!");
		}

	}

}
