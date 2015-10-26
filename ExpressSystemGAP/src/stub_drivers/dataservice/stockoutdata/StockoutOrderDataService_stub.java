package stub_drivers.dataservice.stockoutdata;

import java.util.List;

import util.ResultMessage;
import po.StockinOrderPO;
import po.StockoutOrderPO;
import dataservice.orderdataservice.StockoutOrderDataService;

public class StockoutOrderDataService_stub implements StockoutOrderDataService {
	public List<StockoutOrderPO> list;

	@Override
	public ResultMessage add(StockoutOrderPO po) {
		// TODO 自动生成的方法存根
		for (StockoutOrderPO order : list)
			if (order.getIdentifier().equals(po.getIdentifier()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public StockoutOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		for(StockoutOrderPO order:list){
			if(order.getExpressorder_ids().contains(order_id))
				return order;
		}
		return null;
	}

}
