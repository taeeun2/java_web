package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBEx2 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		//localhost : ip , 3306 : ���� ��Ʈ , app : �����ͺ��̽��� 
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
			//���� �õ�
			conn = DriverManager.getConnection(url,"root","java");
			System.out.println("�����ͺ��̽� ���� ����!");
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ����̹� �ε� ����!");
		}
	}

}
