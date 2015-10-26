package stub_drivers.blservice.stockout;



import java.util.ArrayList;

import util.ResultMessage;
import client.blservice.orderblservice.StockoutOrderService;
import client.vo.ExpressOrderVO;
import client.vo.StockoutOrderVO;





public class StockoutOrderService_driver {
	private void driver(StockoutOrderService stockoutData) {
		StockoutOrderVO a = stockoutData.create(new ArrayList<ExpressOrderVO>(), new StockoutOrderVO(null, "20151026", "上海", "car", "00100011970010100002"));
		if(stockoutData.save(a).equals(ResultMessage.SUCCEED)){
			System.out.println("save succeed");
		}
		
		StockoutOrderVO b = stockoutData.find("00100011970010100002");
	}
	public static void main(String[] args){
		StockoutOrderService stockout = new StockoutOrderService_stub();
		StockoutOrderService_driver driver = new StockoutOrderService_driver();
		driver.driver(stockout);
	}
	
}