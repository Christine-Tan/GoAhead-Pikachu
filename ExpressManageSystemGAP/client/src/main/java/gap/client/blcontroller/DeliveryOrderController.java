package gap.client.blcontroller;

import gap.client.bl.order.DeliveryOrder;
import gap.client.vo.DeliveryOrderVO;
import gap.common.util.ResultMessage;

public class DeliveryOrderController {
	static DeliveryOrder deliveryOrder = new DeliveryOrder();

	static ResultMessage save(DeliveryOrderVO order) {
		return deliveryOrder.save(order);
	}
}
