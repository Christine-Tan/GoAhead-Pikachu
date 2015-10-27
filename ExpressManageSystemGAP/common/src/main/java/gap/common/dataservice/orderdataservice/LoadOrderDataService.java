package gap.common.dataservice.orderdataservice;

import gap.common.po.LoadOrderPO;
import gap.common.util.ResultMessage;

public interface LoadOrderDataService {
	public ResultMessage add(LoadOrderPO po);

	public LoadOrderPO find(String order_id);
}
