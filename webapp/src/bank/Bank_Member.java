package bank;

import java.util.List;

public class Bank_Member {
	private String name;
	private String id;
	private String pw;
	private String email;
	private List<Account> account;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	public Bank_Member(String name, String id, String pw, String email, List<Account> account) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.account = account;
	}
	
	
}