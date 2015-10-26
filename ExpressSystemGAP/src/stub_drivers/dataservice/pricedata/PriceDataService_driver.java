package stub_drivers.dataservice.pricedata;

import po.PricePO;
import util.ResultMessage;

public class PriceDataService_driver {
	public static void main(String[] args) {
		PriceDataService_stub stub = new PriceDataService_stub();
		PricePO price = new PricePO("000","18:23:25",1);
		if (stub.add(price).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(price).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		PricePO get = stub.find("000");
		if (get != null)
			System.out.println("find:id=" + get.getCityId() + ",rate="
					+ get.getRate() + ",base=" + get.getBase());
		get = stub.find("001");
		if (get == null)
			System.out.println("find failed,not found");
		price.setCityId("001");
		if (stub.modify(price).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
}
