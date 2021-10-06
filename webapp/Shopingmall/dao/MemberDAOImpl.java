package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBAction;
import dto.Member;
import dto.UserInfo;

public class MemberDAOImpl{
	
	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {return instance;}
	
	public int insertMember(Member memberVO)throws Exception{
			
			int result = -1;
			Connection conn = DBAction.getInstance().getConnection();
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement("insert into shopingmall.member(id,pwd,name,email,zip_num,address,phone) values(?,?,?,?,?,?,?)");
				pstmt.setString(1,memberVO.getId());
				pstmt.setString(2,memberVO.getPwd());
				pstmt.setString(3,memberVO.getName());
				pstmt.setString(4,memberVO.getEmail());
				pstmt.setString(5,memberVO.getZip_num());
				pstmt.setString(6,memberVO.getAddress());
				pstmt.setString(7,memberVO.getPhone());

				result = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt !=null)pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {}
			}
			
			return result;
		}
	
	
	public boolean overlappedID(String id) {
		boolean result = false;
		
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select id from shopingmall.member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		
		
		return result;
	}
	
	public Member getMember(String id) throws Exception{
		
		Member member = null;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select id, pwd, name from shopingmall.member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
			}
			else {
//				throw new Exception(""); 예외 발생 시 예외 처리!
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		
		return member;
		
	}
	
}
