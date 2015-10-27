package gap.common.po;

import java.util.Date;

public class BillPO {

	private Date billDate;
	private int money;
	private String courierID;
	private String expressOrderID;

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getCourierID() {
		return courierID;
	}

	public void setCourierID(String courierID) {
		this.courierID = courierID;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getExpressOrderID() {
		return expressOrderID;
	}

	public void setExpressOrderID(String expressOrderID) {
		this.expressOrderID = expressOrderID;
	}

}
