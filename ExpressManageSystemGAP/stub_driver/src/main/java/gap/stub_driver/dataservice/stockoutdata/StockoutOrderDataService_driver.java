package gap.stub_driver.dataservice.stockoutdata;

import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;


public class StockoutOrderDataService_driver {
	private void driver(StockoutOrderDataService stockoutData) {
		StockoutOrderPO stockoutOrder1 = new StockoutOrderPO(null, "20151026", "北京", "car", "00100011970010100001");
		StockoutOrderPO stockoutOrder2 = new StockoutOrderPO(null, "20151026", "上海", "car", "00100011970010100002");
		
		if(stockoutData.add(stockoutOrder1).equals(ResultMessage.SUCCEED)){
			System.out.println("add succeed");
		}
		if(stockoutData.add(stockoutOrder2).equals(ResultMessage.SUCCEED)){
			System.out.println("add succeed");
		}
		if (stockoutData.add(stockoutOrder1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,stockoutOrder exited");
		}
		StockoutOrderPO get = stockoutData.find("00100011970010100002");
		if (get != null)
			System.out.println("find:StockoutOrder"+get.getIdentifier());
		
		StockoutOrderPO get1 = stockoutData.find("00100011970010100001");
		if (get1 != null)
			System.out.println("find:StockoutOrder"+get.getIdentifier());
		get1 = stockoutData.find("00100011970010100003");
		if (get == null)
			System.out.println("find failed,not found");
		
	}
	public static void main(String[] args){
		StockoutOrderDataService stockoutData = new StockoutOrderDataService_stub();
		StockoutOrderDataService_driver driver = new StockoutOrderDataService_driver();
		driver.driver(stockoutData);
	}

	
}
