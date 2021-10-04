package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBEx18 {
	
	/*
	 - 그룹화하여 데이터 조회(group by)
	 		: 대표적인 그룹 함수 count(), avg(), min(), max(), sum() 함수 등과, 
	 		   having 절(조건절)을 사용함.
	 [연습 테이블 만들기] : gbtest
	 create table gbtest(
	 		idx int,
	 		type int,
	 		name varchar(10));
	 [레코드 추가]
	insert into gbtest values(1,1,'홍길동');
	insert into gbtest values(2,1,'이순신');
	insert into gbtest values(3,1,'만득이');
	insert into gbtest values(4,1,'개똥이');
	insert into gbtest values(5,1,'칠득이');
	insert into gbtest values(6,1,'갑돌이');
	insert into gbtest values(7,1,'갑순이');
	
	유형(type)별로 갯수를 가져오고 싶은데, 단순히 count 함수로 데이터를 조회하면 전체 갯수만 가져온다
	ex1) 컬럼 그룹화 : type 그룹화를 하여 name 갯수 조회(컬럼 그룹화)
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
//			String msg = result > -1 ? "성공" : "실패";
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
