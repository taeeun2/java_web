package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBEx3 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		//localhost : ip , 3306 : ���� ��Ʈ , app : �����ͺ��̽��� 
		Connection conn = null;
		//��ɾ ��������ִ� ��ü
		Statement stmt = null;
		try {
			Class.forName(driver);
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
			//���� �õ�
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("�����ͺ��̽� ���� ����!");
			//��ɾ�
			String sql = "create table DBTEST(ID varchar(10))";
			//varchar : ���ڸ� ������ �� �ִ�.
			stmt = conn.createStatement();
			//��ɾ� ����
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
		}
	}
}
