package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DB.DBAction;

public class BookTest {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	
	public BookTest() {
		conn = DBAction.getInstance().getConnection();
		pstmt = null;
		rs = null;
		rsmd = null;
	}

	public static void main(String[] args) {
		
		List<BookDTO> Book_arr = new ArrayList<>();
		
		BookDTO book1 = new BookDTO(21424,"Java Basic","김하나","Jaen.kr",15000,"Java 기본 문법");
		Book_arr.add(book1);
		BookDTO book2 = new BookDTO(33455,"JDBC Pro","김철수","Jaen.kr",23000,"");
		Book_arr.add(book2);
		BookDTO book3 = new BookDTO(55355,"Servlet/JSP","박자바","Jaen.kr",41000,"Model12 기반");
		Book_arr.add(book3);
		BookDTO book4 = new BookDTO(35332,"Android App","홍길동","Jaen.kr",25000,"Lightweight Framework");
		Book_arr.add(book4);
		BookDTO book5 = new BookDTO(35335,"OOAD 분석, 설계", "소나무","Jaen.kr",30000,"");
		Book_arr.add(book5);
		
		
		BookTest booktest = new BookTest();
		try {
			
		//db에 insert하기	
		for(BookDTO book : Book_arr) {
			booktest.insertStudent(book);
		}
		//db내용 select하기
		booktest.printAllBooks();
   	 	
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(booktest.rs!=null)booktest.rs.close();
				if(booktest.pstmt!=null)booktest.pstmt.close();
				if(booktest.conn!=null)booktest.conn.close();
			}catch(SQLException e) {}

		}
		
		
	}
	
	 public void insertStudent(BookDTO book) throws Exception{
         // 실습 1번 테이블에 레코드가 insert 되도록 적당한 JDBC 코드로 채우세요.
		 
		String sql = "insert into book_dto(isbn,title,author,publisher,price,desc1) values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, book.getIsbn());
		pstmt.setString(2, book.getTitle());
		pstmt.setString(3, book.getAuthor());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setString(6, book.getDesc());
		pstmt.execute();
		
	 }
		 
	


     public void printAllBooks() throws Exception{
         // 실습 1번 테이블의 모든 레코드가 조회되고 출력되도록 적당한 JDBC 코드로 채우세요.
    	 String sql = "select isbn,title,author,publisher,price,desc1 from book_dto";
    	 pstmt = conn.prepareStatement(sql);
    	 rs = pstmt.executeQuery();
    	 rsmd = rs.getMetaData();
		 int cnt = rsmd.getColumnCount();

	   	 System.out.println("\n********************************** 도서 목록 ******************************");
	   	 while(rs.next()) {
			for(int i=1;i<=cnt;i++) {
				System.out.print(rs.getString(i));
				if(i!=cnt)
					System.out.print("\t|");
			}
			System.out.println();
		}
    	 
    	 
    	 
     }

}
