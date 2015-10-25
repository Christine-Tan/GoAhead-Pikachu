package dataservice.orderdataservice;

import po.DeliveryOrderPO;
import util.ResultMessage;


public interface DeliveryOrderDataService {
	public ResultMessage add(DeliveryOrderPO po);

	public DeliveryOrderPO find(String order_id);
}
