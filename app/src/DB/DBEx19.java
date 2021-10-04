package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DBEx19 {

	/*
	 -like �˻� : ���ڿ� �κ���ġ �˻�(like)
	 		equal ������(=)�� ��� �񱳴�󰪰� ��Ȯ�� ��ġ�ϴ� ���� ������� �˻�
	 		�ݸ�, ���ڰ��� �κ������θ� ��ġ�ص� ������ �˻��� �ϰ��� �ϴ� ��� like ��ɾ� ���
	 		���ڿ��÷� ���� �˻� ���ڰ��� �κ��̶� ��ġ�ϴ� �����͸� ��ȸ������� ���� �� ���
	 		�κ� ��ġ �˻��� ���ؼ� Ư�� ���ڰ� �̿��� ��ġ���� **('_','%')**�� ���
	 -���ϵ� ī�� ����('_','%')
	 	�ǹ�)
	 		1. % : 0�� �̻��� �ڸ����� ���� ���ڿ�.
	 		2. _ : 1�ڸ��� ����.
	 	[����]			    	[����]
	 	�÷��� LIKE '%CD%'			�÷��� �� CD�� ���Ե� ���ڿ��� ��� ���
	 	�÷��� LIKE 'CD%'			�÷��� �� CD�� �����ϴ� ���ڿ��� ���
	 	�÷��� LIKE 'C%D'			�÷��� �� C�� �����ϰ� �߰� ������ �����̵� �������
	 							���ڸ� ���� D�� ���ڿ��� ���
	 	�÷��� LIKE '_CD_'			�÷��� �ڸ����� 4�ڸ��̰�, 1��°, 4��° �ڸ����� �����̵�
	 							������� 2~3��°�� CD�� �� ���ڿ�
	 	�÷��� LIKE 'CD_'			�÷����� 3�ڸ��̰�, CD�� �����ϰ� 3��°���� �����̵� ������� ���ڿ��� ���
	 	�÷��� LIKE 'C_D'			�÷����� 3�ڸ��̰� 1��° ���� C, 3��° ���� D�̰� �߰��� 1�ڸ��� �����̵� ������� ���ڿ��� ���
	 	
	 	[�ǽ����̺� �����] : LSTEST
	 	CREATE TABLE LSTEST(
	 			PHONE VARCHAR(15),
	 			NAME VARCHAR(10));
	 			
	 	[���ڵ� �߰�]
	 	INSERT INTO LSTEST VALUES('011-1234-5678', 'ȫ�浿');
	 	INSERT INTO LSTEST VALUES('011-1234-5678', '�̼���');
	 	INSERT INTO LSTEST VALUES('010-1234-5678', '������');
	 	INSERT INTO LSTEST VALUES('010-1234-5678', '������');
	 	INSERT INTO LSTEST VALUES('010-1234-5678', 'ĥ����');
	 	INSERT INTO LSTEST VALUES('070-1234-5678', '������');
	 */
	public static void main(String[] args) {
		Connection conn = DBAction.getInstance().getConnection();
		Scanner scan = new Scanner(System.in);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
				System.out.println("����˻��� �����մϴ�.");
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				String sql = "select sido from zipcode group by sido";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					if(rs.getString(1).equals("SIDO"))
						break;
					System.out.println(rs.getString(1));
					
				}
				System.out.println("\n�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.print("���ϴ� '��'�� �Է����ּ��� : ");
				String sido = scan.next();
				String sql2 = "select gugun from zipcode where sido like '%"+sido+"%' group by gugun order by sido";
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\n�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.print("���ϴ� '��/��'�� �Է����ּ��� : ");
				String gugun = scan.next();
				String sql3 = "select dong from zipcode where gugun like '%"+gugun+"%' and sido like '%"+sido+"%' group by dong order by dong";
				pstmt = conn.prepareStatement(sql3);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\n�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.print("���ϴ� '��'�� �Է����ּ��� : ");
				String dong = scan.next();
				String sql4 = "select sido, gugun, dong, ri, bldg, bunji, zipcode from zipcode where dong like '%"+dong+"%' and sido like '%"+sido+"%' and gugun like '%"+gugun+"%' order by dong";
				pstmt = conn.prepareStatement(sql4);
				rs = pstmt.executeQuery();
				rsmd = rs.getMetaData();
				int cnt = rsmd.getColumnCount();
				for(int i=1;i<=cnt;i++) {
					String columName = rsmd.getColumnName(i);
					System.out.print(columName +"\t");
				}
				System.out.println("\n-----------------------------");
				int cnt_num=1;
				while(rs.next()) {
					System.out.print(cnt_num+". : ");
					for(int i=1;i<=cnt;i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
					cnt_num++;
				}
				System.out.print("��ȣ : ");
				int num = scan.nextInt();
				rs = pstmt.executeQuery();
				rsmd = rs.getMetaData();
				int idx=1;
				String zip_num="";
				StringBuilder sb = new StringBuilder();

				while(rs.next()) {
					
					if(idx==num) {
						sb.append(rs.getString("sido")).append(" ").append(rs.getString("gugun"))
						.append(" ").append(rs.getString("dong")).append(" ").append(rs.getString("bldg")).append(" ");
						zip_num = rs.getString("zipcode");
					}
					idx++;
				}
				
		
				System.out.println("�����ȣ : "+zip_num);
				System.out.print("���ּҸ� �Է����ּ��� : ");
				
				String detail = new Scanner(System.in).nextLine();
				sb.append(detail);
				System.out.println(sb.toString());
				String zip_address = sb.toString();
//				String detail = scan.next();
//				sb.append().append(scan.next());
//				System.out.println(sb.toString()+new Scanner(System.in).nextLine());
				
			

			
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {}

		}

	}
	/*
	 �ǽ� ����) �����ȣ �˻�
	 		CREATE TABLE ZIPCODE(
	 			ZIPCODE VARCHAR(7),
	 			SIDO VARCHAR(4),
	 			GUGUN VARCHAR(17),
	 			DONG VARCHAR(26),
	 			RI VARCHAR(15),
	 			BLDG VARCHAR(42),
	 			BUNJI VARCHAR(17),
	 			SEQ VARCHAR(5),
	 			PRIMARY KEY(SEQ)
	 			)
	 			
	 */
	
	public static String select() {		
//		String sql = "select phone, name from lstest where phone like '011%'";
//		String sql = "select phone, name from lstest where phone like '%78'";
//		String sql = "select phone, name from lstest where phone like '%70%'";
//		String sql = "select phone, name from lstest where phone like '0%8'";
		String sql = "select phone, name from lstest where name like 'ȫ__' or name like '_��_'";	
		return sql;
	}
	

}
