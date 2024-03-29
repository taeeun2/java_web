package dto;

import java.util.Date;

public class Member_ex {
	private int no;
	private String name;
	private String email;
	private String password;
	private Date createdDate;
	private Date modifieDate;
	public int getNo() {
		return no;
	}
	public Member_ex setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Member_ex setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member_ex setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Member_ex setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Member_ex setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public Date getModifieDate() {
		return modifieDate;
	}
	public Member_ex setModifieDate(Date modifieDate) {
		this.modifieDate = modifieDate;
		return this;
	}
	
}
