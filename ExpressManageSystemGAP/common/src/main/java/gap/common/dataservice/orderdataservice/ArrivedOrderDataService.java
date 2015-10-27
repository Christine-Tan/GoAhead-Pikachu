package gap.common.dataservice.orderdataservice;

import gap.common.po.ArrivedOrderPO;
import gap.common.util.ResultMessage;

public interface ArrivedOrderDataService {
	public ResultMessage add(ArrivedOrderPO po);

	public ArrivedOrderPO find(String order_id);
}
