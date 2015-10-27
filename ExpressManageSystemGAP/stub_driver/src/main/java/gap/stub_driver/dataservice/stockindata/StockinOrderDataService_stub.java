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
