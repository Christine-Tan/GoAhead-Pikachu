package stub_drivers.dataservice.deliveryorderdata;

import java.util.ArrayList;
import java.util.List;

import po.DeliveryOrderPO;
import util.ResultMessage;
import dataservice.orderdataservice.DeliveryOrderDataService;

public class DeliveryOrderDataService_stub implements DeliveryOrderDataService {

	private List<DeliveryOrderPO> list;

	public DeliveryOrderDataService_stub() {
		list = new ArrayList<DeliveryOrderPO>();
	}

	@Override
	public ResultMessage add(DeliveryOrderPO po) {
		// TODO 自动生成的方法存根
		for (DeliveryOrderPO order : list)
			if (order.getId().equals(po.getId()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public DeliveryOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		for (DeliveryOrderPO order : list)
			if (order.getId().equals(order_id))
				return order;
		return null;
	}

}
