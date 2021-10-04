package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

import bank.Member;

public class DBEx4 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			System.out.println("데이터베이스 드라이버 로딩 성공!");
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("데이터베이스 연결 성공!");
			stmt = conn.createStatement();
			String sql = insert8();
			int result = stmt.executeUpdate(sql);//-1 0 1
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
			
			
		}catch(Exception e) {
			System.out.println("데이터베이스 드라이버 로딩 실패!");
		}finally {
			try {
				//순서도 기억!
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	}
	/*
	 * DATA INSERT
	 * @return sql
	 */
	public static String insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("DBTEST 테이블에 값 입력하기 ");
		System.out.print("ID : ");
		String id = scan.next();
		String sql = "insert into DBTEST values('"+id+"')";
		return sql;
	}
	
	public static String insert2() {
		String sql = "create table DBTEST2(ID varchar(10),PW varchar(10))";
		return sql;
	}
	
	public static String insert3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("DBTEST2 테이블에 값 입력하기 ");
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		String sql = "insert into DBTEST2 values('"+id+"','"+pw+"')";
		return sql;
	}
	public static String insert4() {
		String sql = "create table DBTEST3(ID VARCHAR(10), PW VARCHAR(10), AGE INTEGER,CRE_DATE DATETIME)";
		return sql;
	}
	
	public static String insert5() {
		Scanner scan = new Scanner(System.in);
		System.out.println("DBTEST3 테이블에 값 입력하기 ");
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		System.out.print("AGE : ");
		int age = scan.nextInt();
        String sql = "insert into DBTEST3 values('"+id+"','"+pw+"',"+age+",NOW())";
		//String sql = "insert into DBTEST3 values('abc','123',10,NOW())";
		return sql;
	}
	
	public static String insert6() {
		String sql = "create table Bank(NAME VARCHAR(10), ID VARCHAR(15), PW VARCHAR(15), BALANCE LONG, EMAIL VARCHAR(30)"
				+ ",ACCOUNT_NUM VARCHAR(20),CRE_DATE DATETIME)";
		return sql;
	}
	
	public static String insert7() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원 이름 : ");
		String name = scanner.next();
		System.out.println("아이디 : ");
		String id = scanner.next();
		System.out.println("비밀번호 : ");
		String pw = scanner.next();
		System.out.println("잔고 : ");
		long balance = scanner.nextLong();
		System.out.println("이메일 주소 : ");
		String email = scanner.next();
		String account_num = "9002-" + (int)((Math.random()*9999)+1) +"-"+(int)((Math.random()*9999)+1)+"-"+(int)((Math.random()*9)+1);
		System.out.println(name+ "님 앞으로 생성된 계좌번호는 " + account_num +" 입니다.");

		String sql = "insert into Bank values('"+name+"','"+id+"','"+pw+"',"+balance+",'"+email+"','"+account_num+"',NOW())";
		return sql; 
	}
	
	public static String insert8() {
		String sql = "CREATE TABLE TEST2(ID VARCHAR(10) UNIQUE, PW VARCHAR(30),"
				+ "NAME VARCHAR(30), " + 
				"MDATE DATE," + 
				"AGE INT)";
		return sql;
	}
	/*
	 * CREATE TABLE TEST1(
	  		ID VARCHAR(10) NOT NULL,
	  		PW VARCHAR(30),
	  		NAME VARCHAR(30),
	  		MDATE DATE,
	  		AGE INT
	  );
	 */
	
	
	
	//연습문제) DBTEST2 TABLE 만들고 ID, PW 컬럼으로 데이터를 저장하시오.(id, pw, age, date)
	//create table DBTEST3(ID VARCHAR(10), PW VARCHAR(10), AGE INTEGER, CRE_DATE DATETIME);
	//참고) 오라클 : integer -> number/ now()->sysdate
	//insert into DBTEST3 VALUES('ABC','123',10,NOW())
}
