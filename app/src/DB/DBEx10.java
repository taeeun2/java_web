package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import bank.DBConnection;

public class DBEx10 {

	
/*
 - FOREIGN KEY : �ܷ� Ű
  
  : �� ���̺��� �ٸ� ���̺�� �������ִ� ������ �Ѵ�.
  	�ܷ� Ű�� ������ ���̺� ���ڵ带 �Է��ϸ�, ������ �Ǵ� ���̺��� ������ �����ؼ� ���ڵ尡 �Էµȴ�.
  	��, FOREIGN KEY ���������� �ϳ��� ���̺��� �ٸ� ���̺� �����ϰ� �����.
  	FOREIGN KEY ���������� ������ �� �����Ǵ� ���̺��� �ʵ�� �ݵ�� UNIQUE�� PRIMARY KEY ���� ������
  	�����Ǿ� �־�� �Ѵ�.
  	->[���̺� ����]
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
  			
  			
  	* auto_increment : ���������� �÷����� ����ȴ�.
  	* ON UPDATE CASCADE : test4�� �����Ǹ� ���� �����ȴ�.
 
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
			String msg = result > -1 ? "����" : "����";
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
	//����1)	
	//	String sql = "insert into test4(code, item, rdate) values(1,'������1','2021-09-08')";
	//����2)
	//	String sql = "insert into test4(code, item, rdate) values(2,'������2','2021-09-08')";
	//����3)
	//	String sql = "insert into test5(code) values(7)";
	//����4)
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

