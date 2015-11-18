package gap.common.po;

import gap.common.util.Gender;
import gap.common.util.UserType;

import java.io.Serializable;

public class UserPO implements Serializable {
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
	// 用户性别
	private Gender gender;
	// 用户姓名
	private String name;

	public UserPO() {

	}

	public UserPO(String userId, UserType type, String userName, int rank,
			String ins_id, String password, String name, Gender gender) {
		super();
		this.userId = userId;
		this.type = type;
		this.userName = userName;
		this.rank = rank;
		this.ins_id = ins_id;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIns_id() {
		return ins_id;
	}

	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}

	public void setName(String name) {
		userName = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

}
