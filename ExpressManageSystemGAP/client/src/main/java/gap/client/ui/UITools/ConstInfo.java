package gap.client.ui.UITools;

import gap.client.ui.BaseComponents.UserBox.Sex;

public class ConstInfo {
	private static String name;
	private static String job;
	private static String number;
	private static Sex sex;
	
	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ConstInfo.name = name;
	}

	public static String getJob() {
		return job;
	}

	public static void setJob(String job) {
		ConstInfo.job = job;
	}

	public static String getNumber() {
		return number;
	}

	public static void setNumber(String number) {
		ConstInfo.number = number;
	}

	public static Sex getSex() {
		return sex;
	}

	public static void setSex(Sex sex) {
		ConstInfo.sex = sex;
	}
	
}
