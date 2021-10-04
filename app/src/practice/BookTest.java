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
		
		BookDTO book1 = new BookDTO(21424,"Java Basic","���ϳ�","Jaen.kr",15000,"Java �⺻ ����");
		Book_arr.add(book1);
		BookDTO book2 = new BookDTO(33455,"JDBC Pro","��ö��","Jaen.kr",23000,"");
		Book_arr.add(book2);
		BookDTO book3 = new BookDTO(55355,"Servlet/JSP","���ڹ�","Jaen.kr",41000,"Model12 ���");
		Book_arr.add(book3);
		BookDTO book4 = new BookDTO(35332,"Android App","ȫ�浿","Jaen.kr",25000,"Lightweight Framework");
		Book_arr.add(book4);
		BookDTO book5 = new BookDTO(35335,"OOAD �м�, ����", "�ҳ���","Jaen.kr",30000,"");
		Book_arr.add(book5);
		
		
		BookTest booktest = new BookTest();
		try {
			
		//db�� insert�ϱ�	
		for(BookDTO book : Book_arr) {
			booktest.insertStudent(book);
		}
		//db���� select�ϱ�
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
         // �ǽ� 1�� ���̺� ���ڵ尡 insert �ǵ��� ������ JDBC �ڵ�� ä�켼��.
		 
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
         // �ǽ� 1�� ���̺��� ��� ���ڵ尡 ��ȸ�ǰ� ��µǵ��� ������ JDBC �ڵ�� ä�켼��.
    	 String sql = "select isbn,title,author,publisher,price,desc1 from book_dto";
    	 pstmt = conn.prepareStatement(sql);
    	 rs = pstmt.executeQuery();
    	 rsmd = rs.getMetaData();
		 int cnt = rsmd.getColumnCount();

	   	 System.out.println("\n********************************** ���� ��� ******************************");
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
