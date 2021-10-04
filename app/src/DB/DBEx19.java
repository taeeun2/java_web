package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DBEx19 {

	/*
	 -like 검색 : 문자열 부분일치 검색(like)
	 		equal 연산자(=)의 경우 비교대상값과 정확히 일치하는 값을 대상으로 검색
	 		반면, 문자값이 부분적으로만 일치해도 데이터 검색을 하고자 하는 경우 like 명령어 사용
	 		문자열컬럼 내에 검색 문자값이 부분이라도 일치하는 데이터를 조회대상으로 잡을 때 사용
	 		부분 일치 검색을 위해서 특정 문자값 이외의 위치에는 **('_','%')**을 사용
	 -와일드 카드 종류('_','%')
	 	의미)
	 		1. % : 0개 이상의 자리수를 갖는 문자열.
	 		2. _ : 1자리수 문자.
	 	[형식]			    	[설명]
	 	컬럼명 LIKE '%CD%'			컬럼값 중 CD가 포함된 문자열이 모두 대상
	 	컬럼명 LIKE 'CD%'			컬럼값 중 CD로 시작하는 문자열이 대상
	 	컬럼명 LIKE 'C%D'			컬럼값 중 C로 시작하고 중간 값들은 무엇이든 상관없이
	 							끝자리 값이 D인 문자열이 대상
	 	컬럼명 LIKE '_CD_'			컬럼값 자리수가 4자리이고, 1번째, 4번째 자리값은 무엇이든
	 							상관없고 2~3번째에 CD가 들어간 문자열
	 	컬럼명 LIKE 'CD_'			컬럼값이 3자리이고, CD로 시작하고 3번째값은 무엇이든 상관없는 문자열이 대상
	 	컬럼명 LIKE 'C_D'			컬럼값이 3자리이고 1번째 값이 C, 3번째 값이 D이고 중간값 1자리는 무엇이든 상관없는 문자열이 대상
	 	
	 	[실습테이블 만들기] : LSTEST
	 	CREATE TABLE LSTEST(
	 			PHONE VARCHAR(15),
	 			NAME VARCHAR(10));
	 			
	 	[레코드 추가]
	 	INSERT INTO LSTEST VALUES('011-1234-5678', '홍길동');
	 	INSERT INTO LSTEST VALUES('011-1234-5678', '이순신');
	 	INSERT INTO LSTEST VALUES('010-1234-5678', '만득이');
	 	INSERT INTO LSTEST VALUES('010-1234-5678', '개동이');
	 	INSERT INTO LSTEST VALUES('010-1234-5678', '칠득이');
	 	INSERT INTO LSTEST VALUES('070-1234-5678', '갑돌이');
	 */
	public static void main(String[] args) {
		Connection conn = DBAction.getInstance().getConnection();
		Scanner scan = new Scanner(System.in);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
				System.out.println("우편검색을 시작합니다.");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				String sql = "select sido from zipcode group by sido";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					if(rs.getString(1).equals("SIDO"))
						break;
					System.out.println(rs.getString(1));
					
				}
				System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.print("원하는 '시'를 입력해주세요 : ");
				String sido = scan.next();
				String sql2 = "select gugun from zipcode where sido like '%"+sido+"%' group by gugun order by sido";
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.print("원하는 '군/구'를 입력해주세요 : ");
				String gugun = scan.next();
				String sql3 = "select dong from zipcode where gugun like '%"+gugun+"%' and sido like '%"+sido+"%' group by dong order by dong";
				pstmt = conn.prepareStatement(sql3);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.print("원하는 '동'를 입력해주세요 : ");
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
				System.out.print("번호 : ");
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
				
		
				System.out.println("우편번호 : "+zip_num);
				System.out.print("상세주소를 입력해주세요 : ");
				
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
	 실습 문제) 우편번호 검색
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
		String sql = "select phone, name from lstest where name like '홍__' or name like '_순_'";	
		return sql;
	}
	

}
