package po;

import java.util.Date;

public class ReceiptPO {
	
	private int money;
	private Date lastPayDate;
	
	public ReceiptPO(int money,Date lastPayDate){
		this.setMoney(money);
		this.setLastPayDate(lastPayDate);
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(Date lastPayDate) {
		this.lastPayDate = lastPayDate;
	}
	
}
