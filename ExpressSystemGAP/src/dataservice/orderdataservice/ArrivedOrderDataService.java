package dataservice.orderdataservice;

import po.ArrivedOrderPO;
import po.ResultMessage;

public interface ArrivedOrderDataService {
	public ResultMessage add(ArrivedOrderPO po);

	public ArrivedOrderPO find(String order_id);
}
