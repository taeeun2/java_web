package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

public class BankSystem{
	
	Scanner scanner = new Scanner(System.in);
	boolean run, result, log_in, save, send;
	int menuNum,money;
	
	Set<String> set;
	List<Member> member_arr;
	List<Account> account_arr;
	Member member;
	Account account;
	
	Member log_in_member;
	Member send_member;
	

	Account select_account;
	Map<String, String> map;  
	String regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
	String name, id, pw, email, date, account_num, menu, zip_code, zip_address, send_account_num;
	long balance;
	MEMBER[] m = MEMBER.values();
	
	public BankSystem() {
		run = true;
		member_arr = new Vector<>();
		account_arr= new Vector<>();
		map = new Hashtable<>();
		set = new HashSet<>();
		select_account = new Account(account_num, balance);
		log_in = false;
		save = false;
		send = false;
	}

	public static void main(String[] args) {
		
		BankSystem bank = new BankSystem();
//		파일 입력받아 회원가입하기, 회원정보 db에 저장, member_arr, map에 저장
		/*
		try {
			bank.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	
//      db에 있는 정보  member_arr, map에 저장
		bank.db_manager("db_join");
	
		
		do {
			
			bank.print1();
			bank.input1();

			while(bank.log_in) {//로그인 성공시
				bank.print2();
				bank.input2();
				if(bank.save) {//회원정보 파일로 출력하기
					try {
					bank.save();
					System.out.println("회원정보가 출력되었습니다.");
					bank.save=false;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}while(bank.run);
		
		System.out.println("은행시스템이 종료되었습니다.");
		bank.db_manager("close");//conn, stmt, rs닫기

	}
	
	
	public void print1() {
		System.out.println("--------------------------");
		System.out.println("1.회원가입 | 2.로그인|  ");
		System.out.println("--------------------------");
		System.out.print("선택> ");
	}
	
	public void print2() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1.예금 | 2.출금 | 3.잔고  | 4.회원정보 출력 | 5.송금| 6.회원정보 수정 | ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("7.회원탈퇴 | 8.로그아웃 | 9.우편번호 검색 | 10.계좌 개설 | 11.종료 ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("선택> ");
	}
	
	public void input1() {
		menuNum = scanner.nextInt();
		switch(menuNum) {
			case 1:
				//회원가입정보 DB에 저장
				db_manager("join");
				break;
			case 2:
				//로그인
				while(true) {
				System.out.print("아이디 : ");
				id = scanner.next();
				System.out.print("비밀번호 : ");
				pw = scanner.next();
				if(map.containsKey(id)) {
					if(map.get(id).equals(pw)) {
						log_in(id);
						System.out.println(log_in_member.getName()+"님 로그인되었습니다.");
						log_in = true;
						break;
					}
					else
						System.out.println("비밀번호가 일치하지 않습니다.");
				}
				else
					System.out.println("입력하신 아이디가 존재하지 않습니다.");
				}
				
		}
	}
	
	public void input2() {

		menuNum = scanner.nextInt();
		if(menuNum == 11) {
			log_in = false;
			run=false;
		}
		switch(menuNum) {
			case 1:
				db_manager("deposit");
				break;
				
			case 2:
				db_manager("withdraw");
				break;
				
			case 3:

				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("\t계좌번호 리스트");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				for(Account account : log_in_member.getAccount()) {
					System.out.println("계좌번호 : "+account.getAccount_num()+"잔액 :"+account.getBalance()+"원");
				}
				break;
			case 4:
				save = true;
				db_manager("print");
				break;
			
			case 5:
				db_manager("send");
				break;
				
			case 6:
				db_manager("modify");
				break;
				
			case 7:
				member_arr.remove(log_in_member);
				System.out.println("회원탈퇴가 완료되었습니다.");
				//계좌번호 삭제
				for(Account account : log_in_member.getAccount())
					set.remove(account.getAccount_num());
				//map에서 id 삭제	
				map.remove(id);
				//member에서 삭제
				db_manager("delete");
				log_in = false;
				break;
			case 8:
				log_in = false;
				break;
				
			case 9 :
				db_manager("zipcode");
				break;
			case 10:
				db_manager("add_account");
			}
		
		
	}
	
	public void log_in(String id) {
		
		for(Member member_arr : member_arr) {
			if(member_arr.getId().equals(id))
				log_in_member = member_arr;
		}

	}

	public void account_search(String account_num, Member member) {
			
			for(Account account : member.getAccount()) {
				if(account.getAccount_num().equals(account_num))
					select_account = account;
			}
	
	}
	

	public void save() throws IOException{//회원정보 파일로 출력

		File file = new File("C:/work/BankMember.txt");
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fwriter);
		PrintWriter pw = new PrintWriter(bw, true);

		pw.println(new StringBuilder().append("|\t이름\t|\t아이디\t|\t비밀번호\t|\t\t이메일 주소\t\t|\t가입일\t\t|\t계좌번호\t\t|\t잔고\t\t|\t우편번호\t\n"
				+ "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"
				+ "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"));
		
		for(Member member : member_arr) {
			pw.println(new StringBuilder().append("        ").append(member.getName())
					.append("\t\t").append(member.getId()).append("\t\t")
					.append(member.getPw()).append("\t\t").append(member.getEmail())
					.append("\t\t   ").append(member.getDate()).append("\t\t")
					.append(member.getAccount().get(0)).append("\t\t")
					.append(member.getZip_code()));
		}
		
		pw.flush();
		pw.close();
	}
	
	public void join() throws IOException{//회원정보 파일로 입력받아 db에 저장
		//한번에 입력
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		File file = new File("C:/work/BankMember_first.txt");
		FileInputStream input=new FileInputStream(file);
		InputStreamReader reader=new InputStreamReader(input,"UTF-8");
		BufferedReader br = new BufferedReader(reader);
		String str;
	
		while(br.ready()) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			name = st.nextToken();
			id = st.nextToken();
			pw = st.nextToken();
			email = st.nextToken();
			balance = Long.parseLong(st.nextToken());
			date = st.nextToken();

			//계좌번호 중복 방지
			while(true) {
			account_num = "9002-" + (int)((Math.random()*9999)+1) +"-"+(int)((Math.random()*9999)+1)+"-"+(int)((Math.random()*9)+1);
			if(!set.contains(account_num))
				break;
			}

			db_manager(name,id,pw,balance,email,account_num,date);

			
			
			
		}
		br.close();
		
	}

	public void db_manager(String menu){
		
		DBConnection db = DBConnection.getInstance();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {
			stmt = conn.createStatement();
			String sql="";
			switch(menu) {
			case "db_join":
				//db정보 저장
				sql = "select * from bank_member natural join account";
				rs = stmt.executeQuery(sql);
				rsmd = rs.getMetaData();
				while(rs.next()) {
					this.id = rs.getString(1);
					this.name = rs.getString(2);
					this.pw = rs.getString(3);
					this.email = rs.getString(4);
					this.date = rs.getString(5);
					this.zip_code = rs.getString(6);
					this.zip_address = rs.getString(7);
					this.account_num = rs.getString(8);
					this.balance = rs.getLong(9);
					
					
					set.add(account_num);
					if(map.containsKey(id)) {
						log_in(id);
						account = new Account(account_num,balance);
						log_in_member.getAccount().add(account);
					}
					else{	
						map.put(id, pw);
						//우편번호는 우편번호를 검색하고 저장한다.
						//동일한 id에 계좌번호가 2개이상인 것 구분하여 저장
						List<Account> account_arr = new Vector<>();
						account = new Account(account_num,balance);
						account_arr.add(account);
						member = new Member(name,id,pw,email,date,zip_code,zip_address);
						member.setAccount(account_arr);
						member_arr.add(member);
					}
				
				}
			
				break;
				
			case "zipcode":
				//우편번호 검색
				zip_code_search(stmt,rs,rsmd);
				break;
			case "join":
				//회원가입
				insert(stmt, rs, rsmd);
				break;
			case "modify":
				//회원정보 수정
				
				System.out.println("무엇을 수정하시겠습니까?");
				System.out.println("1.이름 | 2.비밀번호 | 3.이메일 주소 |4.우편번호"+"\n선택>");
				menuNum = scanner.nextInt();
				
				System.out.print("비밀번호를 입력해주세요 : ");
				int cnt = 0;
				boolean correct = false;
				while(true) {
					String pw = scanner.next();
					if(pw.equals(map.get(id))) {
						correct = true;
						break;
					}
					cnt++;
					if(cnt==3)
						break;
					System.out.print("다시 입력해주세요 : ");
					
				}
				
				if(correct)
					update(stmt, rs, rsmd);
				else
					System.out.println("비밀번호를 3회 틀리셨으므로 수정이 불가합니다.");
				break;
			case "print":
				//회원정보 출력
				sql = "select * from bank_member";
				rs = stmt.executeQuery(sql);
				rsmd = rs.getMetaData();
				int colums = rsmd.getColumnCount();
				while(rs.next()) {
					for(int i=1;i<=colums;i++) {
						//enum으로 이름, 아이디 등 출력하기
						System.out.print(m[i-1]+": ");
						System.out.println(rs.getString(i)+"\t");
					}
					
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				}
				break;
				
			
			case "delete":
				//회원정보 삭제
				sql = "delete from bank_member where id = '"+id+"'";
				stmt.execute(sql);
				break;
				
			case "deposit":
				//예금
				System.out.println("예금하실 계좌를 선택하시오");
				account_select(stmt, rs, rsmd);
				System.out.print("예금하실 금액을 입력하시오. : ");
				money = scanner.nextInt();
				
				account_search(account_num,log_in_member);
				select_account.deposit(money);
				

				sql = "update account set balance = balance + "+money+" where account_num = '"+account_num+"'";
				stmt.execute(sql);
				
				System.out.println("잔액 : "+select_account.getBalance()+"원");	
				break;
				
			case "withdraw":
				//출금
				System.out.println("출금하실 계좌를 선택하시오");
				account_select(stmt, rs, rsmd);
				System.out.print("출금하실 금액을 입력하시오. : ");
				money = scanner.nextInt();
				
				account_search(account_num,log_in_member);
				select_account.withdraw(money);
				
				sql = "update account set balance = balance - "+money+" where account_num = '"+account_num+"'";
				stmt.execute(sql);
				;
				System.out.println("잔액 : "+select_account.getBalance()+"원");	
				break;
			
			case "send":
				//송금
				send();
				if(send) {
					send = false;
					
					try {

						//로그인한 회원 계좌에서 돈 인출하기
						System.out.println("출금하실 계좌를 선택하시오");
						//계좌 선택
						account_select(stmt, rs, rsmd);
						//선택한 계좌에서 출금
						account_search(account_num,log_in_member);
						select_account.withdraw(money);
						
						Account log_in_account = select_account;
						
						sql = "update account set balance = balance - "+money+" where account_num = '"+account_num+"'";
						stmt.execute(sql);
						
						//송금하고자하는 계좌 찾아 송금
						account_search(send_account_num,send_member);
						select_account.deposit(money);
						

						sql = "update account set balance = balance + "+money+" where account_num = '"+send_account_num+"'";
						stmt.execute(sql);
						
						
						System.out.println("잔액 : "+log_in_account.getBalance()+"원");
						System.out.println("송금 완료");
						
						}catch(Exception e) {
							System.out.println(e.getMessage());
							
						}
					
					
				}
				break;
			
			case "add_account":
				//계좌 개설
				add_account(stmt,rs, rsmd);
				break;
				
				
			case "close":
				//연결 종료
				db.close(rs, stmt, conn);
			}		

			
		}catch(Exception e) {
			e.getMessage();
		}

		
		
	}
	//파일 읽어 db에 저장
	public void db_manager(String name, String id, String pw, long balance, String email, String account_num, String date ){
			
			DBConnection db = DBConnection.getInstance();
			Connection conn = db.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String sql="insert into bank_member values('"+name+"','"+id+"','"+pw+"','"+email+"','"+date+"',null, null)";
				int result = stmt.executeUpdate(sql);
				String msg = result>-1?"회원정보가 등록되었습니다.":"회원정보 등록을 실패하였습니다.";
				System.out.println(msg);
				
				String sql2 = "insert into account values('"+account_num+"',"+balance+",'"+id+"')";
				stmt.executeUpdate(sql2);
				
				set.add(account_num);
				System.out.println(name+ "님 앞으로 생성된 계좌번호는 " + account_num +" 입니다.");
				map.put(id, pw);
				//우편번호와 집주소는 우편번호 검색 후 저장
				
				account = new Account(account_num,balance);
				member = new Member(name,id,pw,email,date,"","");
				member_arr.add(member);

				
			}catch(Exception e) {
				System.out.println("이미 등록된 회원입니다.");
				//e.printStackTrace();
			}
		}
	
	

	public void insert(Statement stmt, ResultSet rs, ResultSetMetaData rsmd)throws Exception{
		System.out.print("회원 이름 : ");
		name = scanner.next();
		System.out.print("아이디 : ");
		id = scanner.next();
		System.out.print("비밀번호 : ");
		pw = scanner.next();
		System.out.print("잔고 : "); 
		balance = scanner.nextLong();
		System.out.print("이메일 주소 : ");
		email = scanner.next();
		
		while(true) {
		if(map.containsKey(id)) { 
			System.out.println("중복된 아이디입니다.");
			System.out.print("아이디 :");
			id = scanner.next();
		}
		else
			break;
		}
		System.out.println("사용할 수 있는 아이디입니다.");
		while(true) {
			result = Pattern.matches(regExp, email);
			if(!result) {
				System.out.println("이메일 형식이 맞지 않습니다.");
				System.out.print("이메일 주소 : ");

				email = scanner.next();
			}
			else
				break;
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.format(cal.getTime());

		
		//계좌번호 중복 방지
		while(true) {
		account_num = "9002-" + (int)((Math.random()*9999)+1) +"-"+(int)((Math.random()*9999)+1)+"-"+(int)((Math.random()*9)+1);
		if(!set.contains(account_num))
			break;
		}
		
		set.add(account_num);
		System.out.println(name+ "님 앞으로 생성된 계좌번호는 " + account_num +" 입니다.");
		map.put(id, pw);
		String sql = "insert into bank_member(name,id,pw,email,cre_date) values('"+name+"','"+id+"','"+pw+"','"+email+"','"+date+"')";
		stmt.execute(sql);
		sql = "insert into account values('"+account_num+"',"+balance+",'"+id+"')";
		stmt.execute(sql);
		
		List<Account> account_arr = new Vector<>();
		account = new Account(account_num,balance);
		account_arr.add(account);
		member = new Member(name,id,pw,email,date,zip_code,zip_address);
		member.setAccount(account_arr);
		member_arr.add(member);
	
	}
	
	
	public void update(Statement stmt, ResultSet rs, ResultSetMetaData rsmd)throws Exception {
	
		String sql = "";
		switch(menuNum) {
			case 1:
				System.out.print("수정할 이름 : ");
				name = scanner.next();
				log_in_member.setName(name);
				System.out.println(name +"님으로 변경되었습니다.");
				sql = "update bank_member set name = '"+name+"' where id = '"+id+"'";
				stmt.execute(sql);
				break;
			case 2:
				System.out.print("수정할 비밀번호 : ");
				String correct_pw = scanner.next();
				map.remove(id);
				map.put(id, correct_pw);
				log_in_member.setPw(correct_pw);
				pw = correct_pw;
				System.out.println("비밀번호가 "+correct_pw+"로 변경되었습니다.");
				sql = "update bank_member set pw = '"+pw+"' where id = '"+id+"'";
				stmt.execute(sql);
				break;
			case 3:
				System.out.print("수정할 이메일 주소 : ");
				email = scanner.next();
				while(true) {
					result = Pattern.matches(regExp, email);
					if(!result) {
						System.out.println("이메일 형식이 맞지 않습니다.");
						System.out.print("이메일 주소 : ");

						email = scanner.next();
					}
					else
						break;
				}
				log_in_member.setPw(email);
				System.out.println("이메일 주소가 "+email+"로 변경되었습니다.");
				sql = "update bank_member set email = '"+email+"' where id = '"+id+"'";
				stmt.execute(sql);
				break;
			case 4:
				zip_code_search(stmt,rs,rsmd);
				break;
				
		}
		
	}
	
	
	public void send() {
		System.out.print("송금하실 계좌번호를 입력해주세요 : ");
		account_num = scanner.next();
		System.out.print("송금하실 금액을 입력해주세요 : ");
		money = scanner.nextInt();
		String sql = "";
		
		
		

		for(Member member_arr : member_arr) {
			for(Account account : member_arr.getAccount()) {
				if(account.getAccount_num().equals(account_num)) {
					System.out.println(member_arr.getName()+"님에게 "+money+"원을 송금하시겠습니까?(y/n)");
					menu = scanner.next();
					switch(menu) {
					case "Y":
					case"Yes":
					case "y":
					case "yes":
						send_member = member;
						send_account_num = account_num;
						send = true;
						break;
					case "No":
					case "N":
					case "n":
					case "no":
						System.out.println("송금이 취소되었습니다.");
						break;
					default:
						System.out.println("잘못입력하셨습니다.");
					}
					
				}
			}
				
		}
		
		
	}
	
	
	public void add_account(Statement stmt, ResultSet rs, ResultSetMetaData rsmd) throws Exception{
		
		System.out.print("계좌를 개설하시겠습니까?(y/n)");
		String ans = scanner.next();
		switch(ans){
			case "Y":
			case "Yes":
			case "y":
			case "yes":
				while(true) {
					account_num = "9002-" + (int)((Math.random()*9999)+1) +"-"+(int)((Math.random()*9999)+1)+"-"+(int)((Math.random()*9)+1);
					if(!set.contains(account_num))
						break;
					}
					
				set.add(account_num);
				System.out.println(log_in_member.getName()+ "님 앞으로 생성된 계좌번호는 " + account_num +" 입니다.");
				
				String sql = "insert into account values('"+account_num+"',0,'"+id+"')";
				stmt.execute(sql);
				account = new Account(account_num,0);
				account_arr = log_in_member.getAccount();
				account_arr.add(account);

				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("\t계좌번호 리스트");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				for(Account account : log_in_member.getAccount()) {
					System.out.println("계좌번호 : "+account.getAccount_num()+"\t잔액 : "+account.getBalance()+"원");
				}
				break;
			case "n":
			case "no":
			case "N":
			case "No":
				System.out.println("계좌 개설이 취소되었습니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				
			
	
		}
		
	}
	
	public void account_select(Statement stmt, ResultSet rs, ResultSetMetaData rsmd) throws Exception{
	
		String sql = "select account_num, balance from account where id = '"+id+"'";
		rs = stmt.executeQuery(sql);
		rsmd = rs.getMetaData();
		int cnt = rsmd.getColumnCount();
		int cnt_num=1;
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("번호\t계좌번호\t\t잔액");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		while(rs.next()) {
			System.out.print(cnt_num+". ");
			for(int i=1;i<=cnt;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
			cnt_num++;
		}
		
		System.out.print("\n몇 번째 계좌를 선택하시겠습니까? ");
		int num = scanner.nextInt();
		rs = stmt.executeQuery(sql);
		cnt_num=1;
		
		
		while(rs.next()) {
			if(cnt_num==num)
				account_num = rs.getString("account_num");
			cnt_num++;
		}
	 }
	
	public void zip_code_search(Statement stmt, ResultSet rs, ResultSetMetaData rsmd) throws Exception{
		
		System.out.println("우편검색을 시작합니다.");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		String sql = "select sido from zipcode group by sido";
		rs = stmt.executeQuery(sql);

		while(rs.next()) {
			if(rs.getString(1).equals("SIDO"))
				break;
			System.out.println(rs.getString(1));
			
		}
		System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("원하는 '시'를 입력해주세요 : ");
		String sido = scanner.next();
		sql = "select gugun from zipcode where sido like '%"+sido+"%' group by gugun order by sido";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("원하는 '군/구'를 입력해주세요 : ");
		String gugun = scanner.next();
		sql = "select dong from zipcode where gugun like '%"+gugun+"%' and sido like '%"+sido+"%' group by dong order by dong";
		
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("원하는 '동'를 입력해주세요 : ");
		String dong = scanner.next();
		sql = "select sido, gugun, dong, ri, bldg, bunji, zipcode from zipcode where dong like '%"+dong+"%' and sido like '%"+sido+"%' and gugun like '%"+gugun+"%' order by dong";
		
		rs = stmt.executeQuery(sql);
		rsmd = rs.getMetaData();
		int cnt = rsmd.getColumnCount();
		for(int i=1;i<=cnt;i++) {
			String columName = rsmd.getColumnName(i);
			System.out.print(columName +"\t");
		}
		System.out.println("\n-----------------------------");
		int cnt_num=1;
		while(rs.next()) {
			System.out.print(cnt_num+". : ");
			for(int i=1;i<=cnt;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
			cnt_num++;
		}
		System.out.print("번호 : ");
		int num = scanner.nextInt();
		rs = stmt.executeQuery(sql);
		rsmd = rs.getMetaData();
		int idx=1;
		String zip_num="";
		StringBuilder sb = new StringBuilder();

		while(rs.next()) {
			
			if(idx==num) {
				sb.append(rs.getString("sido")).append(" ").append(rs.getString("gugun"))
				.append(" ").append(rs.getString("dong")).append(" ").append(rs.getString("ri"))
				.append("").append(rs.getString("bldg")).append(" ");
				zip_num = rs.getString("zipcode");
			}
			idx++;
		}
		

		System.out.println("우편번호 : "+zip_num);
		zip_code = zip_num;
		System.out.print("상세주소를 입력해주세요 : ");
		
		String detail = new Scanner(System.in).nextLine();
		sb.append(detail);
		System.out.println(sb.toString());
		zip_address = sb.toString();
		
		log_in_member.setZip_code(zip_code);
		log_in_member.setZip_address(zip_address);

		sql = "update bank_member set zip_code = '"+zip_code+"' where id = '"+id+"'";
		stmt.execute(sql);
	
		sql = "update bank_member set zip_address = '"+zip_address+"' where id = '"+id+"'";
		stmt.execute(sql);
		
		System.out.println("우편번호 등록이 완료되었습니다.");
		
	
	}
	
	
	public static enum MEMBER{
		이름, 아이디, 비밀번호, 이메일, 가입일, 우편번호, 주소
		//배열구조를 가짐.
	}
}


