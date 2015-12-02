package gap.client.vo;

import java.util.Calendar;
import java.util.Date;

import gap.common.po.PayeePO;
import gap.common.util.PaymentType;
import gap.common.util.UserType;

public class PayeeVO {

	private PaymentType type;
	private String userID;
	private String userName;
	private Calendar lastPaydate;
	private int expressOrderNum = 0;
	private double money = 0;
	private String accountName;
	private String note;


	public PayeeVO(PaymentType type, String userID, String userName,
			Calendar lastPaydate, int expressOrderNum, 
			double money,String accountName,String note) {
		this.type = type;
		this.userID = userID;
		this.userName = userName;
		this.lastPaydate = lastPaydate;
		this.expressOrderNum = expressOrderNum;
		this.money = money;
		this.accountName = accountName;
		this.setNote(note);

		if (type != PaymentType.DELIVERY) {
			expressOrderNum = 0;
		}

	}
	
	public PayeeVO(PayeePO po){
		this.type = po.getType();
		this.userID = po.getUserID();
		this.lastPaydate = po.getLastPaydate();
		this.userName = po.getUserName();
		this.expressOrderNum = po.getExpressOrderNum();
	}

	public PayeePO toPO(){
		PayeePO po = new PayeePO(type, userID, userName, lastPaydate, 
				expressOrderNum, money, accountName);
		po.setNote(note);
		
		return po;
	}
	public PaymentType getType() {
		return type;
	}



	public String getUserName() {
		return userName;
	}



	public String getUserID() {
		return userID;
	}



	public Calendar getLastPaydate() {
		return lastPaydate;
	}



	public int getExpressOrderNum() {
		return expressOrderNum;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
}
