package stub_drivers.dataservice.distancedata;

import dataservice.strategydataservice.DistanceDataService;
import dataservice.transdataservice.CarDataService;
import po.DistancePO;
import stub_drivers.dataservice.cardata.CarDataService_driver;
import stub_drivers.dataservice.cardata.CarDataService_stub;
import util.ResultMessage;

public class DistanceDataService_driver {
	public void driver(DistanceDataService distanceData) {
		DistancePO po = new DistancePO("Nanjing", "Shanghai", 115.0, 89.0,112.3, 85.9);
		if (distanceData.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (distanceData.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (distanceData.add(po).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,distance exited");
		}
		DistancePO get = distanceData.find("Nanjing","Shanghai");
		if (get != null)
			System.out.println("find: from " + get.getStartCity() + " to "
					+ get.getEndCity() + " Distance=" + get.getDistance());
		get = distanceData.find("Nanjing","Beijing");
		if (get == null)
			System.out.println("find failed,not found");
		po.setStartCity("Beijing");
		if (distanceData.modify(po).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
	
	public static void main(String[] args) {
		DistanceDataService distanceData = new DistanceDataService_stub();
		DistanceDataService_driver driver = new DistanceDataService_driver();
		driver.driver(distanceData);
	}
	
}
