package dataservice.orderdataservice;

import po.ArrivedOrderPO;
import util.ResultMessage;


public interface ArrivedOrderDataService {
	public ResultMessage add(ArrivedOrderPO po);

	public ArrivedOrderPO find(String order_id);
}
