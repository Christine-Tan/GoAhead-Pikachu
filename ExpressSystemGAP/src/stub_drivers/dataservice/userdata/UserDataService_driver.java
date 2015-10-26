package stub_drivers.dataservice.userdata;

import po.UserPO;
import util.ResultMessage;
import util.UserType;

public class UserDataService_driver {
	public static void main(String[] args) {
		UserDataService_stub stub = new UserDataService_stub();
		UserPO user1 = new UserPO("100000001", UserType.DELIVERY, "Feifei", 1,"0011001","abc123");
		UserPO user2 = new UserPO("000000001",UserType.ADMINISTRATOR,"Shiny",5,"","admin");
		if (stub.add(user1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(user2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(user1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		UserPO get = stub.find("100000001");
		if (get != null)
			System.out.println("find:name=" + get.getUserName() + ",password="
					+ get.getPassword());
		get = stub.find("100000002");
		if (get == null)
			System.out.println("find failed,not found");
		user1.setUserId("100000002");
		if (stub.modify(user1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (stub.delete("100000002").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (stub.delete("100000002").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}
}
