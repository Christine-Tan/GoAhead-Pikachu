package gap.common.dataservice.orderdataservice;

import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

public interface StockinOrderDataService {
	public ResultMessage add(StockinOrderPO po);

	public StockinOrderPO find(String order_id);
}
