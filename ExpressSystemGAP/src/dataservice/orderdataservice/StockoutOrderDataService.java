package dataservice.orderdataservice;

import po.StockoutOrderPO;
import po.ResultMessage;

public interface StockoutOrderDataService {
	public ResultMessage add(StockoutOrderPO po);

	public StockoutOrderPO find(String order_id);
}
