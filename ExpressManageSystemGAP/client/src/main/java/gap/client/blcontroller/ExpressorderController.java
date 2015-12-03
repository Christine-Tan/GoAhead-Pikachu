package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.expressorder.ExpressOrder;
import gap.client.blservice.expressorderblservice.ExpressOrderService;
import gap.client.exception.InvalidInputException;
import gap.client.vo.ExpressOrderVO;
import gap.common.po.AllAddressPO;
import gap.common.util.CurrentOrderType;
import gap.common.util.ReceiveInfo;
import gap.common.util.ResultMessage;

public class ExpressorderController {
	private static ExpressOrder expressorder = new ExpressOrder();

	public static AllAddressPO getAllAddress() {
		return expressorder.getAllAddress();
	}

	public static ExpressOrderVO createOrder(ExpressOrderVO order_info) {
		// TODO 自动生成的方法存根
		return expressorder.createOrder(order_info);
	}

	public static ResultMessage save(ExpressOrderVO order) {
		// TODO 自动生成的方法存根
		return expressorder.save(order);
	}

	public static ResultMessage receiveOrder(ReceiveInfo receiveInfo) {
		// TODO 自动生成的方法存根
		return expressorder.receiveOrder(receiveInfo);
	}

}
