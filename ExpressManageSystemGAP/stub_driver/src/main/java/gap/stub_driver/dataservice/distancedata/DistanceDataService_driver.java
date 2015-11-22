package gap.stub_driver.dataservice.distancedata;

import java.rmi.RemoteException;

import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.po.CityPO;
import gap.common.util.ResultMessage;

public class DistanceDataService_driver {
	public void driver(CityDataService distanceData) throws RemoteException {
		CityPO po = new CityPO("Nanjing", "Shanghai", 115.0, 89.0,
				112.3, 85.9);
		if (distanceData.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (distanceData.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (distanceData.add(po).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,distance exited");
		}
		CityPO get = distanceData.find("Nanjing", "Shanghai");
		if (get != null)
			System.out.println("find: from " + get.getStartCity() + " to "
					+ get.getEndCity() + " Distance=" + get.getDistance());
		get = distanceData.find("Nanjing", "Beijing");
		if (get == null)
			System.out.println("find failed,not found");
		po.setStartCity("Beijing");
		if (distanceData.modify(po).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}

	public static void main(String[] args) {
		CityDataService distanceData = new DistanceDataService_stub();
		DistanceDataService_driver driver = new DistanceDataService_driver();
		try {
			driver.driver(distanceData);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
