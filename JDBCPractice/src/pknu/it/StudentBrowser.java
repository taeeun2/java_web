package pknu.it;

import java.sql.*;
import java.util.Scanner;

public class StudentBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");//드라이브 등록
				
			
				Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe",
							"DB201712020",
							"201712020");//데이터베이스 연결
				
				System.out.println("검색할 학생의 학번을 입력하세요!");
				Scanner sc = new Scanner(System.in);
				int sno = sc.nextInt();
				
				String sql = "select * "+
				"from enrol natural join course where sno = ?";
			
				PreparedStatement pstmt = conn.prepareStatement(sql);// 1차 sql문 실행
				pstmt.setInt(1, sno);		                         // ?에 값 배정
				ResultSet rs = pstmt.executeQuery();	             // 최종 select문 실행
				
				while(rs.next()) {//결과를 읽음
					String cno = rs.getString("cno");
					String cname = rs.getString("cname");
					String grade = rs.getString("grade");
					System.out.format("과목번호 : %s | 과목이름 : %s | 성적 : %s\n",cno,cname,grade);
				}
				
				rs.close();//결과 집합 닫음
				pstmt.close();//statement 닫음
				conn.close();//연결 닫음
				
			} catch (Exception e) {
				e.printStackTrace();
		
		     }
		}
}


