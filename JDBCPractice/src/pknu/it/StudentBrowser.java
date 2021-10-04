package pknu.it;

import java.sql.*;
import java.util.Scanner;

public class StudentBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");//����̺� ���
				
			
				Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe",
							"DB201712020",
							"201712020");//�����ͺ��̽� ����
				
				System.out.println("�˻��� �л��� �й��� �Է��ϼ���!");
				Scanner sc = new Scanner(System.in);
				int sno = sc.nextInt();
				
				String sql = "select * "+
				"from enrol natural join course where sno = ?";
			
				PreparedStatement pstmt = conn.prepareStatement(sql);// 1�� sql�� ����
				pstmt.setInt(1, sno);		                         // ?�� �� ����
				ResultSet rs = pstmt.executeQuery();	             // ���� select�� ����
				
				while(rs.next()) {//����� ����
					String cno = rs.getString("cno");
					String cname = rs.getString("cname");
					String grade = rs.getString("grade");
					System.out.format("�����ȣ : %s | �����̸� : %s | ���� : %s\n",cno,cname,grade);
				}
				
				rs.close();//��� ���� ����
				pstmt.close();//statement ����
				conn.close();//���� ����
				
			} catch (Exception e) {
				e.printStackTrace();
		
		     }
		}
}


