package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBEx18 {
	
	/*
	 - �׷�ȭ�Ͽ� ������ ��ȸ(group by)
	 		: ��ǥ���� �׷� �Լ� count(), avg(), min(), max(), sum() �Լ� ���, 
	 		   having ��(������)�� �����.
	 [���� ���̺� �����] : gbtest
	 create table gbtest(
	 		idx int,
	 		type int,
	 		name varchar(10));
	 [���ڵ� �߰�]
	insert into gbtest values(1,1,'ȫ�浿');
	insert into gbtest values(2,1,'�̼���');
	insert into gbtest values(3,1,'������');
	insert into gbtest values(4,1,'������');
	insert into gbtest values(5,1,'ĥ����');
	insert into gbtest values(6,1,'������');
	insert into gbtest values(7,1,'������');
	
	����(type)���� ������ �������� ������, �ܼ��� count �Լ��� �����͸� ��ȸ�ϸ� ��ü ������ �����´�
	ex1) �÷� �׷�ȭ : type �׷�ȭ�� �Ͽ� name ���� ��ȸ(�÷� �׷�ȭ)
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
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}

	}
	public static String select() {		
//		String sql = "select type, count(name) as cnt from gbtest where type>1 group by type";
		String sql = "select type, count(name) as cnt from gbtest  where type>1 group by type having cnt>=2 order by type desc";
		return sql;
	}
	

}
