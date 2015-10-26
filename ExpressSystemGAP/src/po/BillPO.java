package po;

import com.mysql.fabric.xmlrpc.base.Data;

public class BillPO {

	private Data billDate;
	private int money;
	private String courierID;
	private String expressOrderID;
	public Data getBillDate() {
		return billDate;
	}
	public void setBillDate(Data billDate) {
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
