package stub_drivers.dataservice.cardata;

import dataservice.transdataservice.CarDataService;
import po.CarPO;
import util.ResultMessage;

public class CarDataService_driver {
	public void driver(CarDataService carData) {
		CarPO car1 = new CarPO("0011001001", "88888", "0011001", 10);
		CarPO car2 = new CarPO("0010001001", "44444", "0010001", 5);
		if (carData.add(car1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (carData.add(car2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (carData.add(car1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		CarPO get = carData.find("0011001001");
		if (get != null)
			System.out.println("find:id=" + get.getCar_id() + ",num="
					+ get.getCar_num() + ",serve_time=" + get.getServe_time());
		get = carData.find("0011001002");
		if (get == null)
			System.out.println("find failed,not found");
		car1.setCar_num("777777");
		if (carData.modify(car1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (carData.delete("0010001001").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (carData.delete("0010001002").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}

	public static void main(String[] args) {
		CarDataService carData = new CarDataService_stub();
		CarDataService_driver driver = new CarDataService_driver();
		driver.driver(carData);

	}
}
