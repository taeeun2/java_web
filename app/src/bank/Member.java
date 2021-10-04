package bank;

import java.util.ArrayList;
import java.util.List;

public class Member{

	private String name;
	private String id;
	private String pw;
	private String email;
	private List<Account> account;
//	
//	public List<Account> getAccount() {
//		List<Account> account_arr = new ArrayList<Account>();
//		account_arr.addAll(this.account);
//		
//		return account_arr;
//	}
//
//	public void setAccount(List<Account> account) {
//		List<Account> account_arr = new ArrayList<Account>();
//		account_arr.addAll(account);
//		this.account = account_arr;
//	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	private String date;
	private String zip_code;
	private String zip_address;
	
	
	
	public String getZip_address() {
		return zip_address;
	}

	public void setZip_address(String zip_address) {
		this.zip_address = zip_address;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public Member(String name, String id, String pw, String email, String date, String zip_code, String zip_address) {
		
		this.name = name;
		this.id = id;
		this.pw = pw;	
		this.zip_code = zip_code;
		this.zip_address = zip_address;
		this.setEmail(email);
		this.setDate(date);
		
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
		
	
}
