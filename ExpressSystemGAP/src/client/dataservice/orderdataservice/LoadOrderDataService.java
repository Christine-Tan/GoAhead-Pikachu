package client.dataservice.orderdataservice;

import client.po.LoadOrderPO;
import client.po.ResultMessage;

public interface LoadOrderDataService {
	public ResultMessage add(LoadOrderPO po);

	public LoadOrderPO find(String order_id);
}
