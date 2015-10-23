package client.dataservice.orderdataservice;

import client.po.DeliveryOrderPO;
import client.po.ResultMessage;

public interface DeliveryOrderDataService {
	public ResultMessage add(DeliveryOrderPO po);

	public DeliveryOrderPO find(String order_id);
}
