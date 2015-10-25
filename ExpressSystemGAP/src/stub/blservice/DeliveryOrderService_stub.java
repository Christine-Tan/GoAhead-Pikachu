package stub.blservice;

import java.util.List;

import po.ResultMessage;
import client.blservice.orderblservice.DeliveryOrderService;
import client.vo.DeliveryOrderVO;
import client.vo.ExpressOrderVO;

public class DeliveryOrderService_stub implements DeliveryOrderService{

	@Override
	public DeliveryOrderVO create(List<ExpressOrderVO> orders,
			DeliveryOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(DeliveryOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DeliveryOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
