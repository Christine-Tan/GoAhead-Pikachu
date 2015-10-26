package stub_drivers.dataservice.distancedata;

import po.DistancePO;
import util.ResultMessage;

public class DistanceDataService_driver {
	public static void main(String[] args) {
		DistanceDataService_stub stub = new DistanceDataService_stub();
		DistancePO po = new DistancePO("Nanjing", "Shanghai", 115.0, 89.0,112.3, 85.9);
		if (stub.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(po).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		DistancePO get = stub.find("Nanjing","Shanghai");
		if (get != null)
			System.out.println("find: from " + get.getStartCity() + " to "
					+ get.getEndCity() + " Distance=" + get.getDistance());
		get = stub.find("Nanjing","Beijing");
		if (get == null)
			System.out.println("find failed,not found");
		po.setStartCity("Beijing");
		if (stub.modify(po).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
}
