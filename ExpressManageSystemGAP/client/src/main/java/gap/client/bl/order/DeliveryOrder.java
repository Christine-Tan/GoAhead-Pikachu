package gap.client.bl.order;

import gap.client.blservice.orderblservice.DeliveryOrderService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.DeliveryOrderDataController;
import gap.client.vo.DeliveryOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public class DeliveryOrder implements DeliveryOrderService {
	DeliveryOrderDataController deliveryOrderData;

	public DeliveryOrder() {
		deliveryOrderData = ControllerFactory.getDeliveryOrderDataController();
	}


	@Override
	public ResultMessage save(DeliveryOrderVO order) {
		// TODO 自动生成的方法存根
		return deliveryOrderData.add(order.toPO());
	}


}
