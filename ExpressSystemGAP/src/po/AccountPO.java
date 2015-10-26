package po;

public class AccountPO {
	
	private String name;
	private int balance;
	
	public AccountPO(String name,int balance) {
	
		this.setName(name);
		this.setBalance(balance);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
