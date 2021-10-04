package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBEx16 {

	/*
	 BETWEEN(����) : A AND B���� A�� B�� ������(inclusive) �� ������ 
	 				��� ���� �ش��ϴ��� ���θ� �������� �Ѵ�.
	 				
	 create table bwtest(
	 	idx int,
	 	birth date,
	 	name varchar(10));
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
			System.out.println("\n-----------------------------");
			while(rs.next()) {
				for(int i=1;i<=cnt;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
			
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}

	}
	
	public static String insert() {
//		String sql = "insert into bwtest values(1,'2020-01-01','ȫ�浿')";
//		String sql = "insert into bwtest values(2,'2020-01-02','�̼���')";
//		String sql = "insert into bwtest values(3,'2020-01-03','�����')";
//		String sql = "insert into bwtest values(4,'2020-02-01','��ȣ��')";
//		String sql = "insert into bwtest values(5,'2020-02-02','���缮')";
//		String sql = "insert into bwtest values(6,'2020-03-01','ȫ����')";
		String sql = "insert into bwtest values(7,'2020-03-02','����')";
		return sql;
	}
	
	public static String select() {
//		String sql = "select * from bwtest where idx between 2 and 5";
//		String sql = "select * from bwtest where idx>=2 and idx<=5";
//		String sql = "select * from bwtest where birth between '2020-01-02' and '2020-01-08'";
		//1~n ���� : rowī��Ʈ�� ����
		String sql = "select * from bwtest limit 3";
		//������ �Խù� n�� ~ n ���ĺ���
//		String sql = "select * from bwtest limit 2 offset 5";
		// �Խù� n���ĺ��� ~ ������ �Խù� n��
//		String sql = "select * from bwtest order by idx desc limit 5, 2";
		
		return sql;
	}

}
