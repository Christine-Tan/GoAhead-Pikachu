package po;

import java.util.Date;

import util.UserType;

public class PayeePO {

	private UserType type;
	private String userID;
	private String userName;
	private Date lastPaydate;
	private int expressOrderNum = 0;
	
	public PayeePO(UserType type,String userID,String userName,Date lastPaydate){
		this(type, userID, userName, lastPaydate,0);
		
	}
	
	public PayeePO(UserType type,String userID,String userName,Date lastPaydate,int expressOrderNum){
		this.setType(type);
		this.setUserID(userID);
		this.setUserName(userName);
		this.setLastPaydate(lastPaydate);
		this.setExpressOrderNum(expressOrderNum);
		
		if(type!=UserType.DELIVERY){
			expressOrderNum = 0;
		}
		
		
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
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

	public Date getLastPaydate() {
		return lastPaydate;
	}

	public void setLastPaydate(Date lastPaydate) {
		this.lastPaydate = lastPaydate;
	}

	public int getExpressOrderNum() {
		return expressOrderNum;
	}

	public void setExpressOrderNum(int expressOrderNum) {
		this.expressOrderNum = expressOrderNum;
	}
	
	
	
	
}
