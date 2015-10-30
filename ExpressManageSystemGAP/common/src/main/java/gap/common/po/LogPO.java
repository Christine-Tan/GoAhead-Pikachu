package gap.common.po;

import java.io.Serializable;
import java.sql.Date;

public class LogPO implements Serializable {

	private UserPO userPO;
	private Date date;
	private String operate;

	public LogPO(UserPO userPO, Date date, String operate) {
		this.setUserPO(userPO);
		this.setDate(date);
		this.setOperate(operate);
	}

	public UserPO getUserPO() {
		return userPO;
	}

	public void setUserPO(UserPO userPO) {
		this.userPO = userPO;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
