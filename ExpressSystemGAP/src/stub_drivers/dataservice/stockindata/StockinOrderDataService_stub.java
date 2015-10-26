package stub_drivers.dataservice.stockindata;

import java.util.List;

import util.ResultMessage;
import po.LoadOrderPO;
import po.StockinOrderPO;
import dataservice.orderdataservice.StockinOrderDataService;

public class StockinOrderDataService_stub implements StockinOrderDataService{
	public List<StockinOrderPO> list;

	@Override
	public ResultMessage add(StockinOrderPO po) {
		// TODO 自动生成的方法存根
		for (StockinOrderPO order : list)
			if (order.getIdentifier().equals(po.getIdentifier()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public StockinOrderPO find(String identifier) {
		// TODO 自动生成的方法存根
		for(StockinOrderPO order:list){
			if(order.getIdentifier().equals(identifier))
				return order;
		}
		return null;
	}

}
