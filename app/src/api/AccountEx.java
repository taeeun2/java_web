package api;

public class AccountEx {

	public static void main(String[] args) {
		Account account = new Account();
		//�����ϱ�
		account.deposit(10000);
		System.out.println("���ݾ� : "+account.getBalance());
		//����ϱ�
		try {
		account.withdraw(30000);
		}catch(Exception e) {
			String message = e.getMessage();
			System.out.println(message);
		}
		
	}

}
