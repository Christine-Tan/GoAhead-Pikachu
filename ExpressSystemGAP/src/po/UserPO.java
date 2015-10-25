package po;

import java.io.Serializable;

public class UserPO implements Serializable {
	// 用户编号
	private long userId;
	// 用户类型
	private String type;
	// 用户名
	private String userName;
	// 用户等级
	private int rank;

	public UserPO() {

	}

	public UserPO(long id, String type, String name) {
		userId = id;
		this.type = type;
		rank = 0;// rankҪ����id�������
	}

	public void setName(String name) {
		userName = name;
	}

	/**
	 * @return userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId Ҫ���õ� userId
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type Ҫ���õ� type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName Ҫ���õ� userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank Ҫ���õ� rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

}
