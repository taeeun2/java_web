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
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("�����ͺ��̽� ���� ����!");
			stmt = conn.createStatement();
			String sql = insert8();
			int result = stmt.executeUpdate(sql);//-1 0 1
			String msg = result > -1 ? "����" : "����";
			System.out.println(msg);
			
			
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
		}finally {
			try {
				//������ ���!
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
		System.out.println("DBTEST ���̺� �� �Է��ϱ� ");
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
		System.out.println("DBTEST2 ���̺� �� �Է��ϱ� ");
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
		System.out.println("DBTEST3 ���̺� �� �Է��ϱ� ");
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
		System.out.println("ȸ�� �̸� : ");
		String name = scanner.next();
		System.out.println("���̵� : ");
		String id = scanner.next();
		System.out.println("��й�ȣ : ");
		String pw = scanner.next();
		System.out.println("�ܰ� : ");
		long balance = scanner.nextLong();
		System.out.println("�̸��� �ּ� : ");
		String email = scanner.next();
		String account_num = "9002-" + (int)((Math.random()*9999)+1) +"-"+(int)((Math.random()*9999)+1)+"-"+(int)((Math.random()*9)+1);
		System.out.println(name+ "�� ������ ������ ���¹�ȣ�� " + account_num +" �Դϴ�.");

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
	
	
	
	//��������) DBTEST2 TABLE ����� ID, PW �÷����� �����͸� �����Ͻÿ�.(id, pw, age, date)
	//create table DBTEST3(ID VARCHAR(10), PW VARCHAR(10), AGE INTEGER, CRE_DATE DATETIME);
	//����) ����Ŭ : integer -> number/ now()->sysdate
	//insert into DBTEST3 VALUES('ABC','123',10,NOW())
}
