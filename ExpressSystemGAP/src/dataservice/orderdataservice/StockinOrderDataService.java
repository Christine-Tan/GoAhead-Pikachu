package dataservice.orderdataservice;

import po.StockinOrderPO;
import po.ResultMessage;

public interface StockinOrderDataService {
	public ResultMessage add(StockinOrderPO po);

	public StockinOrderPO find(String order_id);
}
