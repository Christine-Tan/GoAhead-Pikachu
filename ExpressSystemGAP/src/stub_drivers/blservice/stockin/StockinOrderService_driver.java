package stub_drivers.blservice.stockin;

import java.util.ArrayList;





import client.blservice.orderblservice.StockinOrderService;
import client.vo.ExpressOrderVO;
import client.vo.StockinOrderVO;
import util.ResultMessage;


public class StockinOrderService_driver {
	private void driver(StockinOrderService stockinData) {
		StockinOrderVO a = stockinData.create(new ArrayList<ExpressOrderVO>(), new StockinOrderVO(null, "20151026", "上海", "car", "00100011970010100002"));
		if(stockinData.save(a).equals(ResultMessage.SUCCEED)){
			System.out.println("save succeed");
		}
		
		StockinOrderVO b = stockinData.find("00100011970010100002");
	}
	public static void main(String[] args){
		StockinOrderService stockin = new StockinOrderService_stub();
		StockinOrderService_driver driver = new StockinOrderService_driver();
		driver.driver(stockin);
	}
}
