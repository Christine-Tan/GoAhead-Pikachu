package gap.common.dataservice.orderdataservice;

import gap.common.po.DeliveryOrderPO;
import gap.common.util.ResultMessage;

public interface DeliveryOrderDataService {
	public ResultMessage add(DeliveryOrderPO po);

	public DeliveryOrderPO find(String order_id);
}
