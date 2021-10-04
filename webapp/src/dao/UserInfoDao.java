package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBAction;
import dto.UserInfo;

public class UserInfoDao {

	public List<UserInfo> selectList() throws Exception{
		ArrayList<UserInfo> userInfos = null;
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM USERINFO ORDER BY NAME ASC");
			userInfos = new ArrayList<UserInfo>();
			while(rs.next()) {
				UserInfo userInfo = 
						new UserInfo().setId(rs.getString("id"))
						.setName(rs.getString("name")).setPw(rs.getString("pw"));
				userInfos.add(userInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e) {}
		}
		return userInfos;
	}
	public UserInfo exist(String id, String pw) throws Exception{
		UserInfo userinfo = null;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select id,pw,name from userinfo where id = ? and pw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userinfo = new UserInfo().setId(rs.getString("ID"))
						.setName(rs.getString("NAME")).setPw(rs.getString("PW"));
				
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
		
		
		return userinfo;
	}

	public int insert(UserInfo userinfo)throws Exception{
		
		int result = -1;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into userinfo values(?,?,?)");
			pstmt.setString(1,userinfo.getId());
			pstmt.setString(2,userinfo.getPw());
			pstmt.setString(3,userinfo.getName());
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
	
	public UserInfo selectOne(String id) throws Exception{
		UserInfo userinfo = null;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select id, pw, name from userinfo where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userinfo = new UserInfo().setId(rs.getString("id"))
						.setName(rs.getString("name")).setPw(rs.getString("pw"));
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
		return userinfo;
	}
	
	public int update(UserInfo userinfo)throws Exception{
		int result = -1;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update userinfo set pw = ?, name = ? where id = ?");
			pstmt.setString(1,userinfo.getPw());
			pstmt.setString(2,userinfo.getName());
			pstmt.setString(3,userinfo.getId());
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
	
	public int delete(String id)throws Exception{
		int result = -1;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from userinfo where id = ?");
			pstmt.setString(1,id);
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
			pstmt = conn.prepareStatement("select id from userinfo where id = ?");
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
}
