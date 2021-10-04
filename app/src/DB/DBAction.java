package DB;

import java.sql.Connection;
import java.sql.DriverManager;

//�̱���
//�ϳ��� ��ü ����, �ݺ������� �����ҷ��� �ϴ� �� ����
public class DBAction {

	private static DBAction instance = new DBAction();
	private Connection conn;
	public DBAction() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/app";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","java");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static DBAction getInstance() {
		if(instance == null) {
			instance = new DBAction();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void close() {
		try {
			if(conn !=null) conn.close();
		}catch(Exception e) {}
	}
}
