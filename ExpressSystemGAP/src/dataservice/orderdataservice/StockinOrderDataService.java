package dataservice.orderdataservice;

import po.StockinOrderPO;
import util.ResultMessage;


public interface StockinOrderDataService {
	public ResultMessage add(StockinOrderPO po);

	public StockinOrderPO find(String order_id);
}
