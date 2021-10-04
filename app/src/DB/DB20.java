package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB20 {

	/*
	 	JOIN
	 	JOIN�� �����ͺ��̽� ���� ���� ���̺��� ������ ���ڵ带 �����Ͽ�
	 	�ϳ��� ���̺��̳� ��� �������� ǥ�����ݴϴ�.
	 	�̷� JOIN�� ���� SELECT���� �Բ� ���� ���˴ϴ�.
	 	ǥ�� SQL������ ���ڵ带 �����ϴ� ��Ŀ� ���� JOIN�� ������ ���� �����մϴ�.
	 	
	 	1. CROSS join
	 	2. EQUI join
	 	3. LEFT JOIN
	 	4/ RIGHT JOIN
	 	
	 	[�ǽ� ���̺�1 �����] : JNTEST1
	 	
	 	CREATE TABLE JNTEST1(
	 			ID INT primary key auto_increment,
	 			PHONE VARCHAR(15),
	 			NAME VARCHAR(10)
	 			);
	 			
	 	[���ڵ� �߰�]
	 	
	 	INSERT INTO JNTEST1(PHONE, NAME) VALUES('011-1234-5678', 'ȫ�浿');
	 	INSERT INTO JNTEST1(PHONE, NAME) VALUES('011-1234-5678', '�̼���');
	 	INSERT INTO JNTEST1(PHONE, NAME) VALUES('010-1234-5678', '������');
	 	INSERT INTO JNTEST1(PHONE, NAME) VALUES('010-1234-5678', '������');
	 	INSERT INTO JNTEST1(PHONE, NAME) VALUES('010-1234-5678', 'ĥ����');
	 	INSERT INTO JNTEST1(PHONE, NAME) VALUES('070-1234-5678', '������');
	 	
	 	[�ǽ� ���̺�2�����] : JNTEST2
	 	
	 	CREATE TABLE JNTEST2(
	 			ID INT,
	 			MDATE DATE,
	 			NAME VARCHAR(10)
	 	);
	 	
	 	[���ڵ� �߰�]
	 	INSERT INTO JNTEST2 VALUES(1, '2001-01-01', '�౸����');
	 	INSERT INTO JNTEST2 VALUES(2, '2001-01-02', '�󱸼���');
	 	INSERT INTO JNTEST2 VALUES(3, '2001-01-03', '�豸����');
	 	INSERT INTO JNTEST2 VALUES(7, '2001-01-04', '�豸����2');
	 	
	 	
	 	1. CROSS JOIN
	 	CROSS JOIN�� ī��� ���̶�� �ϸ� ���εǴ� �� ���̺��� �������� ��ȯ�Ѵ�.
	 	ũ�ν� ������ ���� �����ϰ� ������ �⺻
	 	��� ���� �� �������� ������ ����ȭ�� �����ͺ��̽����� ������ �ʴ´�.
	 	ù ��° ���̺��� ����� �� ��° ���̺��� ����� ���� �͸�ŭ�� ���� ��ȯ.
	 	(����� ǥ��, �Ͻ��� ǥ��)
	 	
	 	2. EQUI JOIN(INNER EQUI JOIN)
	 	WHERE���� ���ǿ����� "="�� ����Ͽ� �ߺ���(������) ���� ����� ������.
	 		
	 	3. LEFT JOIN(LEFT OUTER JOIN)
	 	LEFT��� ���� FROM������ ������ ���� �Ǵ� ù ��° ���̺��� ����.
	 	���� ���̺��� �� + ���̺�� ���� ���̺��� �ߺ��� ���� �����ݴϴ�.
	 	���� ���̺��� �������� JOIN, ������� A���̺��� ��� �����Ϳ� A���̺��
	 	B���̺��� �ߺ��Ǵ� ���� �˻�.
	 	
	 	3. RIGHT JOIN(LEFT OUTER JOIN)
	 	RIGHT��� ���� FROM������ ������  ������ �Ǵ� �� ��° ���̺��� ����.
	 	���� ���̺��� �� + ���̺�� ���� ���̺��� �ߺ��� ���� �����ݴϴ�.
	 	������ ���̺��� �������� JOIN, ������� B���̺��� ��� �����Ϳ� A���̺��
	 	B���̺��� �ߺ��Ǵ� ���� �˻�.
	 	
	 */
	public static void main(String[] args) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
//		String sql = insert();
		String sql = select();
		
		try {
			pstmt = conn.prepareStatement(sql);
//			int result = pstmt.executeUpdate();
//			String msg = result > -1 ? "����" : "����";
//			System.out.println(msg);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
			for(int i=1;i<=cnt;i++) {
				String columName = rsmd.getColumnName(i);
				System.out.print(columName +"\t");
			}
			System.out.println("\n-------------------------------------------");
			while(rs.next()) {
				for(int i=1;i<=cnt;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
			
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}

	}
	
	public static String select() {	
		//ex1)
//		String sql = "SELECT * FROM JNTEST1 CROSS JOIN JNTEST2"; //(�����)
//		String sql = "SELECT * FROM JNTEST1 CROSS, JNTEST2";//(������)
		//ex2)
//		String sql = "SELECT * FROM JNTEST1 T1 INNER JOIN JNTEST2 T2 ON T1.ID = T2.ID";
//		String sql = "SELECT * FROM JNTEST1 T1, JNTEST2 T2 WHERE T1.ID = T2.ID";
		//ex3)
//		String sql = "SELECT * FROM JNTEST1 T1 LEFT OUTER JOIN JNTEST2 T2 ON T1.ID = T2.ID IS NULL";
		//ex4)
		String sql = "SELECT * FROM JNTEST1 T1 RIGHT OUTER JOIN JNTEST2 T2 ON T1.ID = T2.ID";
		return sql;
	}
	
	

}
