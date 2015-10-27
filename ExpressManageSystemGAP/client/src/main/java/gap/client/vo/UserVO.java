package gap.client.vo;

import gap.common.util.UserType;

/**
 * 
 * @author YangYanfei
 *
 */
public class UserVO {
	// 用户编号
	private String userId;
	// 用户类型
	private UserType type;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 用户等级
	private int rank;
	// 指向所属机构id
	private String ins_id;

	public UserVO() {

	}

	public UserVO(String userId, UserType type, String userName, int rank,
			String ins_id, String password) {
		super();
		this.userId = userId;
		this.type = type;
		this.userName = userName;
		this.rank = rank;
		this.ins_id = ins_id;
		this.password = password;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return type
	 */
	public UserType getType() {
		return type;
	}

	/**
	 * @param type 要设置的 type
	 */
	public void setType(UserType type) {
		this.type = type;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank 要设置的 rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return ins_id
	 */
	public String getIns_id() {
		return ins_id;
	}

	/**
	 * @param ins_id 要设置的 ins_id
	 */
	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}

}
