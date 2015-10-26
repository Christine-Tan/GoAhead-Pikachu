package po;

import java.util.Date;

public class PaymentPO {
	private Date payDate;
	private int monry;
	private String userID;
	private String userName;
	private String accountName;
	private String note;
	private PaymetnType type;
	
	public PaymentPO(Date payDate,int money,String userID,String userName,
			String accountName,String note,PaymetnType type){
		
		this.setPayDate(payDate);
		this.setMonry(money);
		this.setUserID(userID);
		this.setUserName(userName);
		this.setAccountName(accountName);
		this.setNote(note);
		this.setType(type);
		
		
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getMonry() {
		return monry;
	}

	public void setMonry(int monry) {
		this.monry = monry;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public PaymetnType getType() {
		return type;
	}

	public void setType(PaymetnType type) {
		this.type = type;
	}
	
}
