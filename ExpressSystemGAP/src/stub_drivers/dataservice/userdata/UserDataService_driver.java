package stub_drivers.dataservice.userdata;

import dataservice.userdataservice.UserDataService;
import po.UserPO;
import util.ResultMessage;
import util.UserType;

public class UserDataService_driver {
	public void driver(UserDataService userData) {
		UserPO user1 = new UserPO("100000001", UserType.DELIVERY, "Feifei", 1,"0011001","abc123");
		UserPO user2 = new UserPO("000000001",UserType.ADMINISTRATOR,"Shiny",5,"","admin");
		if (userData.add(user1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (userData.add(user2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (userData.add(user1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		UserPO get = userData.find("100000001");
		if (get != null)
			System.out.println("find:name=" + get.getUserName() + ",password="
					+ get.getPassword());
		get = userData.find("100000002");
		if (get == null)
			System.out.println("find failed,not found");
		user1.setUserId("100000002");
		if (userData.modify(user1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (userData.delete("100000002").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (userData.delete("100000002").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}
	
	public static void main(String[] args) {
		UserDataService userData = new UserDataService_stub();
		UserDataService_driver driver = new UserDataService_driver();
		driver.driver(userData);
	}
}
