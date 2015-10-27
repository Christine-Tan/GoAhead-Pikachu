package gap.common.po;

import java.util.Date;

public class RentPO {

	private int money;
	private Date lastPayedDate;

	public RentPO(int money, Date lastPayedDate) {
		this.setMoney(money);
		this.setLastPayedDate(lastPayedDate);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getLastPayedDate() {
		return lastPayedDate;
	}

	public void setLastPayedDate(Date lastPayedDate) {
		this.lastPayedDate = lastPayedDate;
	}

}
