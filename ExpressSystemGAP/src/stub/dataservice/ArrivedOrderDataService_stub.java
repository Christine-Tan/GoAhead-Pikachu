package stub.dataservice;

import java.util.ArrayList;
import java.util.List;

import po.ArrivedOrderPO;
import util.ResultMessage;
import dataservice.orderdataservice.ArrivedOrderDataService;

public class ArrivedOrderDataService_stub implements ArrivedOrderDataService {

	private List<ArrivedOrderPO> list;

	public ArrivedOrderDataService_stub() {
		list = new ArrayList<ArrivedOrderPO>();
	}

	@Override
	public ResultMessage add(ArrivedOrderPO po) {
		// TODO 自动生成的方法存根
		for (ArrivedOrderPO order : list)
			if (po.getId().equals(order.getId()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public ArrivedOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		for (ArrivedOrderPO order : list)
			if (order_id.equals(order.getId()))
				return order;
		return null;
	}
}
