package gap.common.dataservice.orderdataservice;

import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

public interface StockoutOrderDataService {
	public ResultMessage add(StockoutOrderPO po);

	public StockoutOrderPO find(String identifier);
}
