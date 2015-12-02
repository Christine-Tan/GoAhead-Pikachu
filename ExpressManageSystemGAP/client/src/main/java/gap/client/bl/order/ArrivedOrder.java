package gap.client.bl.order;

import java.util.List;

import gap.client.blservice.orderblservice.ArrivedOrderService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.orderdata.ArrivedOrderDataController;
import gap.client.vo.ArrivedOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.ResultMessage;

public class ArrivedOrder implements ArrivedOrderService {

	ArrivedOrderDataController arrivedOrderData;

	public ArrivedOrder() {
		arrivedOrderData = ControllerFactory.getArrivedOrderDataController();
	}

	@Override
	public ArrivedOrderVO create(List<ExpressOrderVO> orders,
			ArrivedOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(ArrivedOrderVO order) {
		// TODO 自动生成的方法存根
		return arrivedOrderData.add(order.toPO());
	}

	@Override
	public ArrivedOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
