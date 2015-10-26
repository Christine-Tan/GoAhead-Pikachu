package stub_drivers.dataservice.driverdata;

import po.DriverPO;
import util.Gender;
import util.ResultMessage;

public class DriverDataService_driver {
	public static void main(String[] args) {
		DriverDataService_stub stub = new DriverDataService_stub();
		DriverPO driver1 = new DriverPO("0011001001", "0011001", "yyf",
				"19960301", "500113199603013932", "15520065137", "20200101",
				Gender.MALE);
		DriverPO driver2 = new DriverPO("0010001001", "0010001", "txy",
				"19700101", "500000000000000000", "119", "20200101",
				Gender.FEMALE);
		System.out.println("add succeed");

		if (stub.add(driver2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(driver1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,Driver exited");
		}
		DriverPO get = stub.find("0011001001");
		if (get != null)
			System.out.println("find:id=" + get.getId() + ",name="
					+ get.getName() + ",gender=" + get.getGender() + ",phone="
					+ get.getPhone());
		get = stub.find("0011001002");
		if (get == null)
			System.out.println("find failed,not found");
		driver1.setPhone("110");
		if (stub.modify(driver1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (stub.delete("0010001001").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (stub.delete("0010001002").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}
}
