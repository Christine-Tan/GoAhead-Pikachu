package stub_drivers.dataservice.pricedata;

import dataservice.strategydataservice.PriceDataService;
import po.PricePO;
import util.ResultMessage;

public class PriceDataService_driver {
	public void driver(PriceDataService priceData) {
		PricePO price = new PricePO("000","18:23:25",1);
		if (priceData.add(price).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (priceData.add(price).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,price exited");
		}
		PricePO get = priceData.find("000");
		if (get != null)
			System.out.println("find:id=" + get.getCityId() + ",rate="
					+ get.getRate() + ",base=" + get.getBase());
		get = priceData.find("001");
		if (get == null)
			System.out.println("find failed,not found");
		price.setCityId("001");
		if (priceData.modify(price).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
	
	public static void main(String[] args) {
		PriceDataService priceData = new PriceDataService_stub();
		PriceDataService_driver driver = new PriceDataService_driver();
		driver.driver(priceData);
	}
}
