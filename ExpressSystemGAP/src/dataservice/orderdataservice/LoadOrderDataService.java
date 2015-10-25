package dataservice.orderdataservice;

import po.LoadOrderPO;
import util.ResultMessage;


public interface LoadOrderDataService {
	public ResultMessage add(LoadOrderPO po);

	public LoadOrderPO find(String order_id);
}
