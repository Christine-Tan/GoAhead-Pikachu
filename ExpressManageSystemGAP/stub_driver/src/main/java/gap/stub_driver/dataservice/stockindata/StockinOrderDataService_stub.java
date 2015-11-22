package gap.stub_driver.dataservice.stockindata;

import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

import java.util.List;

public class StockinOrderDataService_stub implements StockinOrderDataService{
	public List<StockinOrderPO> list;

	@Override
	public ResultMessage add(StockinOrderPO po) {
		// TODO 自动生成的方法存根
		for (StockinOrderPO order : list)
			if (order.getId().equals(po.getId()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public StockinOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		for(StockinOrderPO order:list){
			if(order.getId().equals(order_id))
				return order;
		}
		return null;
	}

}
