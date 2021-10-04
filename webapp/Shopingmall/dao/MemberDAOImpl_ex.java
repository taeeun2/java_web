package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import controller.Component;
import dto.Member_ex;

@Component("memberDao")
public class MemberDAOImpl_ex implements MemberDAO{

	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	public List<Member_ex> selectList() throws Exception{
		ArrayList<Member_ex> members = null;
//		Connection conn = DBAction.getInstance().getConnection();
		
		System.out.println("list");
		Connection conn = ds.getConnection();
		System.out.println("conn : "+conn);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno,mname,email,cre_date from members order by mno asc");
			members = new ArrayList<Member_ex>();
			while(rs.next()) {
				members.add(new Member_ex().setNo(rs.getInt("MNO")).setName(rs.getString("mname"))
						.setEmail(rs.getString("email")).setCreatedDate(rs.getDate("cre_date")));
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e) {}
		}
		return members;
	}
	
	
	public int insert(Member_ex member) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into members(email,mname,pwd,cre_date,mod_date) values(?,?,?,now(),now())")		;
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			return stmt.executeUpdate();
		}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(stmt !=null)stmt.close();
					if(conn !=null)conn.close();
				}catch(Exception e) {}
			
		} 
		
	}
	public int delete(int no)throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from members where mno =?");
			stmt.setInt(1, no);
			return stmt.executeUpdate();
		}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(stmt !=null)stmt.close();
					if(conn !=null)conn.close();
				}catch(Exception e) {}
			
		} 
	}
	public Member_ex selectOne(int no) throws Exception{
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno,mname,email,cre_date from members where mno ="+no);
			
			if(rs.next()) {
				return new Member_ex()
				.setNo(rs.getInt("MNO")).setName(rs.getString("mname"))
				.setEmail(rs.getString("email")).setCreatedDate(rs.getDate("cre_date"));
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e) {}
		}
		return null;
	}
	public int update(Member_ex member)throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update members set email=?, mname=?, pwd=?, mod_date=now() where mno = ?");
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			stmt.setInt(4, member.getNo());
			return stmt.executeUpdate();
		}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(stmt !=null)stmt.close();
					if(conn !=null)conn.close();
				}catch(Exception e) {}
			
		} 
		
	}
	public Member_ex exist(String email, String password)throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select mname, email from members where email=? and pwd=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return new Member_ex().setName(rs.getString("mname"))
						.setEmail(rs.getString("email"));
			}
			else {
				return null;
			}
		}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt !=null)stmt.close();
					if(conn !=null)conn.close();
				}catch(Exception e) {}
			
		} 
	}
}
