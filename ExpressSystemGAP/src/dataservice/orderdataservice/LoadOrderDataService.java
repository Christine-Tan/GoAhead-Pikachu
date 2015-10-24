package dataservice.orderdataservice;

import po.LoadOrderPO;
import po.ResultMessage;

public interface LoadOrderDataService {
	public ResultMessage add(LoadOrderPO po);

	public LoadOrderPO find(String order_id);
}
