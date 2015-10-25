package stub.dataservice;

import java.util.ArrayList;

import po.ArrivedOrderPO;
import po.ExpressOrderPO;
import stub.Data_stub;
import util.ResultMessage;
import dataservice.orderdataservice.ArrivedOrderDataService;

public class ArrivedOrderDataService_stub implements ArrivedOrderDataService {

	@Override
	public ResultMessage add(ArrivedOrderPO po) {
		// TODO 自动生成的方法存根
		if (po.getId().equals("1970010100001"))
			return ResultMessage.EXITED;
		return ResultMessage.SUCCEED;
	}

	@Override
	public ArrivedOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		if (!order_id.equals("1970010100001"))
			return null;
		ArrivedOrderPO po = new ArrivedOrderPO();
		po.setId("1970010100001");
		po.setTime("19700101");
		ArrayList<ExpressOrderPO> list = new ArrayList<>();
		list.add(Data_stub.ORDER[0]);
		po.setOrders(list);
		return po;
	}

}
