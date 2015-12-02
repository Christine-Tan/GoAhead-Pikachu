package gap.client.vo;

import java.util.Date;

import gap.common.po.PayeePO;
import gap.common.util.UserType;

public class PayeeVO {

	private UserType type;
	private String userID;
	private String userName;
	private Date lastPaydate;
	private int expressOrderNum = 0;

	public PayeeVO(UserType type, String userID, String userName,
			Date lastPaydate) {
		this(type, userID, userName, lastPaydate, 0);

	}

	public PayeeVO(UserType type, String userID, String userName,
			Date lastPaydate, int expressOrderNum) {
		this.type = type;
		this.userID = userID;
		this.lastPaydate = lastPaydate;
		this.userName = userName;
		this.expressOrderNum = expressOrderNum;

		if (type != UserType.DELIVERY) {
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
		PayeePO po = new PayeePO(type, userID, userName, lastPaydate,expressOrderNum);
		return po;
	}
	public UserType getType() {
		return type;
	}



	public String getUserName() {
		return userName;
	}



	public String getUserID() {
		return userID;
	}



	public Date getLastPaydate() {
		return lastPaydate;
	}



	public int getExpressOrderNum() {
		return expressOrderNum;
	}

	
}
