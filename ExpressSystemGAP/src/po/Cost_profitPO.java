package po;

public class Cost_profitPO {
	
	private String accountName;
	private int income;
	private int payment;
	
	public Cost_profitPO(String accountName,int income,int payment) {
		this.setAccountName(accountName);
		this.setIncome(income);
		this.setPayment(payment);
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
	
}
