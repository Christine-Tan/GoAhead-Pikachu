package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.expressorder.ExpressOrder;
import gap.client.blservice.expressorderblservice.ExpressOrderService;
import gap.client.exception.InvalidInputException;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.CurrentOrderType;
import gap.common.util.ReceiveInfo;
import gap.common.util.ResultMessage;

public class ExpressorderController {
	private static ExpressOrder expressorder = new ExpressOrder();

	public static List<String> getState(String order_id)
			throws InvalidInputException {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ExpressOrderVO getOrder(String order_id)
			throws InvalidInputException {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ResultMessage modify(ExpressOrderVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static List<ExpressOrderVO> getArrivingOrders(String ins_id)
			throws InvalidInputException {
		// TODO 自动生成的方法存根
		return null;
	}

	public static List<ExpressOrderVO> getCurrentOrders(String ins_id,
			CurrentOrderType type) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ResultMessage setArrivedOrders(List<ExpressOrderVO> orders,
			String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ResultMessage setOffOders(List<ExpressOrderVO> orders,
			String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ExpressOrderVO createOrder(ExpressOrderVO order_info) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ResultMessage save(ExpressOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ResultMessage receiveOrder(ReceiveInfo receiveInfo) {
		// TODO 自动生成的方法存根
		return expressorder.receiveOrder(receiveInfo);
	}

}
