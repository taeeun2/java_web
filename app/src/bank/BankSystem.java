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
//		���� �Է¹޾� ȸ�������ϱ�, ȸ������ db�� ����, member_arr, map�� ����
		/*
		try {
			bank.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	
//      db�� �ִ� ����  member_arr, map�� ����
		bank.db_manager("db_join");
	
		
		do {
			
			bank.print1();
			bank.input1();

			while(bank.log_in) {//�α��� ������
				bank.print2();
				bank.input2();
				if(bank.save) {//ȸ������ ���Ϸ� ����ϱ�
					try {
					bank.save();
					System.out.println("ȸ�������� ��µǾ����ϴ�.");
					bank.save=false;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}while(bank.run);
		
		System.out.println("����ý����� ����Ǿ����ϴ�.");
		bank.db_manager("close");//conn, stmt, rs�ݱ�

	}
	
	
	public void print1() {
		System.out.println("--------------------------");
		System.out.println("1.ȸ������ | 2.�α���|  ");
		System.out.println("--------------------------");
		System.out.print("����> ");
	}
	
	public void print2() {
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("1.���� | 2.��� | 3.�ܰ�  | 4.ȸ������ ��� | 5.�۱�| 6.ȸ������ ���� | ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("7.ȸ��Ż�� | 8.�α׾ƿ� | 9.������ȣ �˻� | 10.���� ���� | 11.���� ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("����> ");
	}
	
	public void input1() {
		menuNum = scanner.nextInt();
		switch(menuNum) {
			case 1:
				//ȸ���������� DB�� ����
				db_manager("join");
				break;
			case 2:
				//�α���
				while(true) {
				System.out.print("���̵� : ");
				id = scanner.next();
				System.out.print("��й�ȣ : ");
				pw = scanner.next();
				if(map.containsKey(id)) {
					if(map.get(id).equals(pw)) {
						log_in(id);
						System.out.println(log_in_member.getName()+"�� �α��εǾ����ϴ�.");
						log_in = true;
						break;
					}
					else
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
				else
					System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");
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

				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.println("\t���¹�ȣ ����Ʈ");
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				for(Account account : log_in_member.getAccount()) {
					System.out.println("���¹�ȣ : "+account.getAccount_num()+"�ܾ� :"+account.getBalance()+"��");
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
				System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.");
				//���¹�ȣ ����
				for(Account account : log_in_member.getAccount())
					set.remove(account.getAccount_num());
				//map���� id ����	
				map.remove(id);
				//member���� ����
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
	

	public void save() throws IOException{//ȸ������ ���Ϸ� ���

		File file = new File("C:/work/BankMember.txt");
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fwriter);
		PrintWriter pw = new PrintWriter(bw, true);

		pw.println(new StringBuilder().append("|\t�̸�\t|\t���̵�\t|\t��й�ȣ\t|\t\t�̸��� �ּ�\t\t|\t������\t\t|\t���¹�ȣ\t\t|\t�ܰ�\t\t|\t������ȣ\t\n"
				+ "�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�"
				+ "�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�"));
		
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
	
	public void join() throws IOException{//ȸ������ ���Ϸ� �Է¹޾� db�� ����
		//�ѹ��� �Է�
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

			//���¹�ȣ �ߺ� ����
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
				//db���� ����
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
						//������ȣ�� ������ȣ�� �˻��ϰ� �����Ѵ�.
						//������ id�� ���¹�ȣ�� 2���̻��� �� �����Ͽ� ����
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
				//������ȣ �˻�
				zip_code_search(stmt,rs,rsmd);
				break;
			case "join":
				//ȸ������
				insert(stmt, rs, rsmd);
				break;
			case "modify":
				//ȸ������ ����
				
				System.out.println("������ �����Ͻðڽ��ϱ�?");
				System.out.println("1.�̸� | 2.��й�ȣ | 3.�̸��� �ּ� |4.������ȣ"+"\n����>");
				menuNum = scanner.nextInt();
				
				System.out.print("��й�ȣ�� �Է����ּ��� : ");
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
					System.out.print("�ٽ� �Է����ּ��� : ");
					
				}
				
				if(correct)
					update(stmt, rs, rsmd);
				else
					System.out.println("��й�ȣ�� 3ȸ Ʋ�������Ƿ� ������ �Ұ��մϴ�.");
				break;
			case "print":
				//ȸ������ ���
				sql = "select * from bank_member";
				rs = stmt.executeQuery(sql);
				rsmd = rs.getMetaData();
				int colums = rsmd.getColumnCount();
				while(rs.next()) {
					for(int i=1;i<=colums;i++) {
						//enum���� �̸�, ���̵� �� ����ϱ�
						System.out.print(m[i-1]+": ");
						System.out.println(rs.getString(i)+"\t");
					}
					
					System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				}
				break;
				
			
			case "delete":
				//ȸ������ ����
				sql = "delete from bank_member where id = '"+id+"'";
				stmt.execute(sql);
				break;
				
			case "deposit":
				//����
				System.out.println("�����Ͻ� ���¸� �����Ͻÿ�");
				account_select(stmt, rs, rsmd);
				System.out.print("�����Ͻ� �ݾ��� �Է��Ͻÿ�. : ");
				money = scanner.nextInt();
				
				account_search(account_num,log_in_member);
				select_account.deposit(money);
				

				sql = "update account set balance = balance + "+money+" where account_num = '"+account_num+"'";
				stmt.execute(sql);
				
				System.out.println("�ܾ� : "+select_account.getBalance()+"��");	
				break;
				
			case "withdraw":
				//���
				System.out.println("����Ͻ� ���¸� �����Ͻÿ�");
				account_select(stmt, rs, rsmd);
				System.out.print("����Ͻ� �ݾ��� �Է��Ͻÿ�. : ");
				money = scanner.nextInt();
				
				account_search(account_num,log_in_member);
				select_account.withdraw(money);
				
				sql = "update account set balance = balance - "+money+" where account_num = '"+account_num+"'";
				stmt.execute(sql);
				;
				System.out.println("�ܾ� : "+select_account.getBalance()+"��");	
				break;
			
			case "send":
				//�۱�
				send();
				if(send) {
					send = false;
					
					try {

						//�α����� ȸ�� ���¿��� �� �����ϱ�
						System.out.println("����Ͻ� ���¸� �����Ͻÿ�");
						//���� ����
						account_select(stmt, rs, rsmd);
						//������ ���¿��� ���
						account_search(account_num,log_in_member);
						select_account.withdraw(money);
						
						Account log_in_account = select_account;
						
						sql = "update account set balance = balance - "+money+" where account_num = '"+account_num+"'";
						stmt.execute(sql);
						
						//�۱��ϰ����ϴ� ���� ã�� �۱�
						account_search(send_account_num,send_member);
						select_account.deposit(money);
						

						sql = "update account set balance = balance + "+money+" where account_num = '"+send_account_num+"'";
						stmt.execute(sql);
						
						
						System.out.println("�ܾ� : "+log_in_account.getBalance()+"��");
						System.out.println("�۱� �Ϸ�");
						
						}catch(Exception e) {
							System.out.println(e.getMessage());
							
						}
					
					
				}
				break;
			
			case "add_account":
				//���� ����
				add_account(stmt,rs, rsmd);
				break;
				
				
			case "close":
				//���� ����
				db.close(rs, stmt, conn);
			}		

			
		}catch(Exception e) {
			e.getMessage();
		}

		
		
	}
	//���� �о� db�� ����
	public void db_manager(String name, String id, String pw, long balance, String email, String account_num, String date ){
			
			DBConnection db = DBConnection.getInstance();
			Connection conn = db.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String sql="insert into bank_member values('"+name+"','"+id+"','"+pw+"','"+email+"','"+date+"',null, null)";
				int result = stmt.executeUpdate(sql);
				String msg = result>-1?"ȸ�������� ��ϵǾ����ϴ�.":"ȸ������ ����� �����Ͽ����ϴ�.";
				System.out.println(msg);
				
				String sql2 = "insert into account values('"+account_num+"',"+balance+",'"+id+"')";
				stmt.executeUpdate(sql2);
				
				set.add(account_num);
				System.out.println(name+ "�� ������ ������ ���¹�ȣ�� " + account_num +" �Դϴ�.");
				map.put(id, pw);
				//������ȣ�� ���ּҴ� ������ȣ �˻� �� ����
				
				account = new Account(account_num,balance);
				member = new Member(name,id,pw,email,date,"","");
				member_arr.add(member);

				
			}catch(Exception e) {
				System.out.println("�̹� ��ϵ� ȸ���Դϴ�.");
				//e.printStackTrace();
			}
		}
	
	

	public void insert(Statement stmt, ResultSet rs, ResultSetMetaData rsmd)throws Exception{
		System.out.print("ȸ�� �̸� : ");
		name = scanner.next();
		System.out.print("���̵� : ");
		id = scanner.next();
		System.out.print("��й�ȣ : ");
		pw = scanner.next();
		System.out.print("�ܰ� : "); 
		balance = scanner.nextLong();
		System.out.print("�̸��� �ּ� : ");
		email = scanner.next();
		
		while(true) {
		if(map.containsKey(id)) { 
			System.out.println("�ߺ��� ���̵��Դϴ�.");
			System.out.print("���̵� :");
			id = scanner.next();
		}
		else
			break;
		}
		System.out.println("����� �� �ִ� ���̵��Դϴ�.");
		while(true) {
			result = Pattern.matches(regExp, email);
			if(!result) {
				System.out.println("�̸��� ������ ���� �ʽ��ϴ�.");
				System.out.print("�̸��� �ּ� : ");

				email = scanner.next();
			}
			else
				break;
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.format(cal.getTime());

		
		//���¹�ȣ �ߺ� ����
		while(true) {
		account_num = "9002-" + (int)((Math.random()*9999)+1) +"-"+(int)((Math.random()*9999)+1)+"-"+(int)((Math.random()*9)+1);
		if(!set.contains(account_num))
			break;
		}
		
		set.add(account_num);
		System.out.println(name+ "�� ������ ������ ���¹�ȣ�� " + account_num +" �Դϴ�.");
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
				System.out.print("������ �̸� : ");
				name = scanner.next();
				log_in_member.setName(name);
				System.out.println(name +"������ ����Ǿ����ϴ�.");
				sql = "update bank_member set name = '"+name+"' where id = '"+id+"'";
				stmt.execute(sql);
				break;
			case 2:
				System.out.print("������ ��й�ȣ : ");
				String correct_pw = scanner.next();
				map.remove(id);
				map.put(id, correct_pw);
				log_in_member.setPw(correct_pw);
				pw = correct_pw;
				System.out.println("��й�ȣ�� "+correct_pw+"�� ����Ǿ����ϴ�.");
				sql = "update bank_member set pw = '"+pw+"' where id = '"+id+"'";
				stmt.execute(sql);
				break;
			case 3:
				System.out.print("������ �̸��� �ּ� : ");
				email = scanner.next();
				while(true) {
					result = Pattern.matches(regExp, email);
					if(!result) {
						System.out.println("�̸��� ������ ���� �ʽ��ϴ�.");
						System.out.print("�̸��� �ּ� : ");

						email = scanner.next();
					}
					else
						break;
				}
				log_in_member.setPw(email);
				System.out.println("�̸��� �ּҰ� "+email+"�� ����Ǿ����ϴ�.");
				sql = "update bank_member set email = '"+email+"' where id = '"+id+"'";
				stmt.execute(sql);
				break;
			case 4:
				zip_code_search(stmt,rs,rsmd);
				break;
				
		}
		
	}
	
	
	public void send() {
		System.out.print("�۱��Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
		account_num = scanner.next();
		System.out.print("�۱��Ͻ� �ݾ��� �Է����ּ��� : ");
		money = scanner.nextInt();
		String sql = "";
		
		
		

		for(Member member_arr : member_arr) {
			for(Account account : member_arr.getAccount()) {
				if(account.getAccount_num().equals(account_num)) {
					System.out.println(member_arr.getName()+"�Կ��� "+money+"���� �۱��Ͻðڽ��ϱ�?(y/n)");
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
						System.out.println("�۱��� ��ҵǾ����ϴ�.");
						break;
					default:
						System.out.println("�߸��Է��ϼ̽��ϴ�.");
					}
					
				}
			}
				
		}
		
		
	}
	
	
	public void add_account(Statement stmt, ResultSet rs, ResultSetMetaData rsmd) throws Exception{
		
		System.out.print("���¸� �����Ͻðڽ��ϱ�?(y/n)");
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
				System.out.println(log_in_member.getName()+ "�� ������ ������ ���¹�ȣ�� " + account_num +" �Դϴ�.");
				
				String sql = "insert into account values('"+account_num+"',0,'"+id+"')";
				stmt.execute(sql);
				account = new Account(account_num,0);
				account_arr = log_in_member.getAccount();
				account_arr.add(account);

				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.println("\t���¹�ȣ ����Ʈ");
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				for(Account account : log_in_member.getAccount()) {
					System.out.println("���¹�ȣ : "+account.getAccount_num()+"\t�ܾ� : "+account.getBalance()+"��");
				}
				break;
			case "n":
			case "no":
			case "N":
			case "No":
				System.out.println("���� ������ ��ҵǾ����ϴ�.");
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				
			
	
		}
		
	}
	
	public void account_select(Statement stmt, ResultSet rs, ResultSetMetaData rsmd) throws Exception{
	
		String sql = "select account_num, balance from account where id = '"+id+"'";
		rs = stmt.executeQuery(sql);
		rsmd = rs.getMetaData();
		int cnt = rsmd.getColumnCount();
		int cnt_num=1;
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("��ȣ\t���¹�ȣ\t\t�ܾ�");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		while(rs.next()) {
			System.out.print(cnt_num+". ");
			for(int i=1;i<=cnt;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
			cnt_num++;
		}
		
		System.out.print("\n�� ��° ���¸� �����Ͻðڽ��ϱ�? ");
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
		
		System.out.println("�����˻��� �����մϴ�.");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		String sql = "select sido from zipcode group by sido";
		rs = stmt.executeQuery(sql);

		while(rs.next()) {
			if(rs.getString(1).equals("SIDO"))
				break;
			System.out.println(rs.getString(1));
			
		}
		System.out.println("\n�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("���ϴ� '��'�� �Է����ּ��� : ");
		String sido = scanner.next();
		sql = "select gugun from zipcode where sido like '%"+sido+"%' group by gugun order by sido";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("\n�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("���ϴ� '��/��'�� �Է����ּ��� : ");
		String gugun = scanner.next();
		sql = "select dong from zipcode where gugun like '%"+gugun+"%' and sido like '%"+sido+"%' group by dong order by dong";
		
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("\n�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("���ϴ� '��'�� �Է����ּ��� : ");
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
		System.out.print("��ȣ : ");
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
		

		System.out.println("������ȣ : "+zip_num);
		zip_code = zip_num;
		System.out.print("���ּҸ� �Է����ּ��� : ");
		
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
		
		System.out.println("������ȣ ����� �Ϸ�Ǿ����ϴ�.");
		
	
	}
	
	
	public static enum MEMBER{
		�̸�, ���̵�, ��й�ȣ, �̸���, ������, ������ȣ, �ּ�
		//�迭������ ����.
	}
}

