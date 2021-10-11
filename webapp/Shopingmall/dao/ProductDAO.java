package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBAction;
import dto.ProductVO;

public class ProductDAO {
	//싱글톤 : instance 생성을 한번만 해준다.
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {return instance;}
	
	public ArrayList<ProductVO> listNewProduct() throws Exception{
		ArrayList<ProductVO> productList = new ArrayList<>();
		Connection conn =DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from shopingmall.new_pro_view");	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return productList;
	}
	
	public ArrayList<ProductVO> listBestProduct() throws Exception{
		ArrayList<ProductVO> productList = new ArrayList<>();
		Connection conn =DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from shopingmall.best_pro_view");	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return productList;
	}
	
	public ProductVO getOne(int pseq)throws Exception{
		ProductVO product = new ProductVO();
		Connection conn =DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from shopingmall.product where pseq = ?");	
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
			product.setName(rs.getString("name"));
			product.setPrice2(rs.getInt("price2"));
			product.setImage(rs.getString("image"));
			product.setContent(rs.getString("content"));
			}
			else {
				System.out.println("상품의 상세정보가 존재하지 않습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return product;
	}
	
	
	public ArrayList<ProductVO> getKind(int kind)throws Exception{
		ArrayList<ProductVO> productList = new ArrayList<>();
		Connection conn =DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from shopingmall.product where kind = ?");	
			pstmt.setInt(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setContent(rs.getString("content"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return productList;
	}
}
