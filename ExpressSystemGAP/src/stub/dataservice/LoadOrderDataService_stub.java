package stub.dataservice;

import java.util.List;

import po.ArrivedOrderPO;
import po.DeliveryOrderPO;
import po.LoadOrderPO;
import util.ResultMessage;
import dataservice.orderdataservice.LoadOrderDataService;

public class LoadOrderDataService_stub implements LoadOrderDataService {

	public List<LoadOrderPO> list;

	@Override
	public ResultMessage add(LoadOrderPO po) {
		// TODO 自动生成的方法存根
		for (LoadOrderPO order : list)
			if (order.getLoaded_id().equals(po.getLoaded_id()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public LoadOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		for (LoadOrderPO order : list)
			if (order.getLoaded_id().equals(order_id))
				return order;
		return null;
	}

}
