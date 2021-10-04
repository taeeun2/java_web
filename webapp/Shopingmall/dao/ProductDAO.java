package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBAction;
import dto.ProductVO;

public class ProductDAO {
	//�̱��� : instance ������ �ѹ��� ���ش�.
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
	
}