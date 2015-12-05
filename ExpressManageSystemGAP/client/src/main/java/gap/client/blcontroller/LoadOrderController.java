package gap.client.blcontroller;

import gap.client.bl.order.LoadOrder;
import gap.client.vo.LoadOrderVO;
import gap.common.util.ResultMessage;

public class LoadOrderController {
	private static LoadOrder loadOrder = new LoadOrder();

	public static ResultMessage save(LoadOrderVO loadOrderVO) {
		return loadOrder.save(loadOrderVO);
	}

}
