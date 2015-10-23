package client.dataservice.orderdataservice;

import client.po.ArrivedOrderPO;
import client.po.ResultMessage;

public interface ArrivedOrderDataService {
	public ResultMessage add(ArrivedOrderPO po);

	public ArrivedOrderPO find(String order_id);
}
