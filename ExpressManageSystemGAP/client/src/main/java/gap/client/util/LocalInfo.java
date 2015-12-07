package gap.client.util;

import gap.common.util.Gender;
import gap.common.util.UserType;

import java.util.HashMap;

public class LocalInfo {
	public static User localuser;
	public static String ins_id;
	private static HashMap<UserType, String> jobMap;

	static {
		jobMap = new HashMap<>();
		jobMap.put(UserType.ACCOUNTER, "财务人员");
		jobMap.put(UserType.ADMINISTRATOR, "管理员");
		jobMap.put(UserType.BUSSINESSCLERK, "营业厅业务员");
		jobMap.put(UserType.CENTERCLERK, "中心业务员");
		jobMap.put(UserType.DELIVERY, "快递员");
		jobMap.put(UserType.INVENTORY, "仓库管理员");
		jobMap.put(UserType.MANAGER, "总经理");
	}

	public static String getIns_ID() {
		return ins_id;
	}

	public static String getName() {
		return localuser.getName();
	}

	public static String getUserID() {
		return localuser.getUserId();
	}

	public static String getJob() {
		return jobMap.get(localuser.getType());
	}

	public static Gender getGendar() {
		return localuser.getGender();
	}

}
