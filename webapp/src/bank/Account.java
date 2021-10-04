package bank;



public class Account {
	private String account_num;
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public Account(String account_num, long balance) {
		this.account_num = account_num;
		this.balance = balance;
	}

	public void deposit(int money) {
		balance+=money;
	}
	public void withdraw(int money) throws BalanceInsufficientException{
		if(balance<money) {
			throw new BalanceInsufficientException("�ܰ���� : "+(money-balance)+"�� ���ڶ��ϴ�.");
		}
		balance-=money;
	}
}
