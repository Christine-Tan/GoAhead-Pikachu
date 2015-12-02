package gap.client.bl.order;

import java.util.List;

import gap.client.blservice.orderblservice.DeliveryOrderService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.orderdata.DeliveryOrderDataController;
import gap.client.vo.DeliveryOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.ResultMessage;

public class DeliveryOrder implements DeliveryOrderService {
	DeliveryOrderDataController deliveryOrderData;

	public DeliveryOrder() {
		deliveryOrderData = ControllerFactory.getDeliveryOrderDataController();
	}

	@Override
	public DeliveryOrderVO create(List<ExpressOrderVO> orders,
			DeliveryOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(DeliveryOrderVO order) {
		// TODO 自动生成的方法存根
		return deliveryOrderData.add(order.toPO());
	}

	@Override
	public DeliveryOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
