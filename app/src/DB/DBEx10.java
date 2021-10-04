package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import bank.DBConnection;

public class DBEx10 {

	
/*
 - FOREIGN KEY : 외래 키
  
  : 한 테이블을 다른 테이블과 연결해주는 역할을 한다.
  	외래 키가 설정된 테이블에 레코드를 입력하면, 기준이 되는 테이블의 내용을 참조해서 레코드가 입력된다.
  	즉, FOREIGN KEY 제약조건은 하나의 테이블을 다른 테이블에 의존하게 만든다.
  	FOREIGN KEY 제약조건을 설정할 때 참조되는 테이블의 필드는 반드시 UNIQUE나 PRIMARY KEY 제약 조건이
  	설정되어 있어야 한다.
  	->[테이블 생성]
  	CREATE TABLE TEST4( --parent
  			CODE 	INT PRIMARY KEY,
  			ITEM	VARCHAR(30),
  			RDate 	DATE
  			);
  	
  	CREATE TABLE TEST5( --child
  			NUM 	INT PRIMARY KEY auto_increment,
  			CODE 	INT
  			FOREIGN KEY (CODE)
  			REFERENCES TEST4(CODE) ON UPDATE CASCADE
  			);
  			
  			
  	* auto_increment : 순차적으로 컬럼값이 적용된다.
  	* ON UPDATE CASCADE : test4가 삭제되면 같이 삭제된다.
 
 */
	
	
	
	
	
	
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
		//	String sql = insert();
		//	String sql = select();
		//	String sql = create();
		//	String sql = update();
			String sql = delete();
			
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
//			rs = stmt.executeQuery(sql);
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int cnt = rsmd.getColumnCount();
//			while(rs.next()) {
//				for(int i=1;i<=cnt;i++) {
//					System.out.print(rs.getString(i)+"\t");
//				}
//				System.out.println();
//			}
//			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			db.close(rs, stmt, conn);
		}
	}
	
	public static String select() {
//		String sql = "select * from test4";
		String sql = "select * from test5";

		return sql;
	}
	
	public static String insert() {
		Scanner scan = new Scanner(System.in);
//		System.out.print("ID : ");
//		String id = scan.next();
//		System.out.print("PW : ");
//		String pw = scan.next();
//		System.out.print("NAME : ");
//		String name = scan.next();
		//	String sql = "insert into test3 values('"+id+"','"+pw+"','"+name+"',"
		//			+ " '2021-09-08', 10)";
	//실행1)	
	//	String sql = "insert into test4(code, item, rdate) values(1,'아이템1','2021-09-08')";
	//실행2)
	//	String sql = "insert into test4(code, item, rdate) values(2,'아이템2','2021-09-08')";
	//실행3)
	//	String sql = "insert into test5(code) values(7)";
	//실행4)
		String sql = "insert into test5(code) values(2)";
		
		return sql;
	}

	public static String create() {
//		String sql = "create table test4(" + 
//				"  			CODE INT PRIMARY KEY," + 
//				"  			ITEM VARCHAR(30)," + 
//				"  			RDate DATE" + 
//				"  			)";
		
		String sql = "CREATE TABLE TEST5(" + 
				"  			NUM INT PRIMARY KEY auto_increment,"
				+ "         CODE INT,"
				+ "			FOREIGN KEY(CODE)"
				+ "			REFERENCES TEST4(CODE) ON UPDATE CASCADE"
				+ "         ON DELETE CASCADE" +  
				"  			)";
		return sql;
		
		
	}
	
	public static String update() {
		String sql = "update test4 set code = 7 where code = 2";
		return sql;
	}
	
	public static String delete() {
		String sql = "delete from test5 where code = 7";
		return sql;
	}
	
}
//	create table test5(
//			num int primary key auto_increment,
//			code int,
//		    foreign key(code) 
//		    references test4(code) on update cascade
//			on delete cascade
//		    );

