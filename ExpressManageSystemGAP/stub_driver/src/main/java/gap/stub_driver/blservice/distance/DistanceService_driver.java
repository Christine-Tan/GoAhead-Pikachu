package gap.stub_driver.blservice.distance;

import gap.client.blservice.strategyblservice.DistanceService;
import gap.client.vo.DistanceVO;
import gap.common.util.ResultMessage;

public class DistanceService_driver {
	public void driver(DistanceService distance) {
		DistanceVO vo = new DistanceVO("Nanjing", "Shanghai", 300.5);
		if (distance.add(vo).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (distance.add(vo).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (distance.add(vo).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,distance exited");
		}
		DistanceVO get = distance.getDistance("Nanjing", "Shanghai");
		if (get != null)
			System.out.println("find: from " + get.getStartCity() + " to "
					+ get.getEndCity() + " distance=" + get.getDistance());
		get = distance.getDistance("Nanjing", "Beijing");
		if (get == null)
			System.out.println("find failed,not found");
		vo.setStartCity("Beijing");
		if (distance.modifyDistance(vo).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}

	public static void main(String[] args) {
		DistanceService distance = new DistanceService_stub();
		DistanceService_driver driver = new DistanceService_driver();
		driver.driver(distance);
	}
}
