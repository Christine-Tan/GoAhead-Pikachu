package gap.client.util;

import gap.client.vo.UserVO;
import gap.common.po.UserPO;
import gap.common.util.Gender;
import gap.common.util.UserType;

public class User {
	UserType userType;
	String name, user_id, password;
	Gender gender;

	public User(UserPO user) {
		userType = user.getType();
		name = user.getName();
		user_id = user.getIns_id();
		gender = user.getGender();
		password=user.getPassword();
	}

	public User(UserType userType, String name, String user_id, String password, Gender gender) {
		super();
		this.userType = userType;
		this.name = name;
		this.user_id = user_id;
		this.password=password;
		this.gender = gender;
	}
 
//	public UserVO toUserVO(){
//		return new UserVO(user_id,userType,name,password);
//	}
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
