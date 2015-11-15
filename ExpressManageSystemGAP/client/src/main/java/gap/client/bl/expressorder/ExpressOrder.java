package gap.client.bl.expressorder;

import java.util.List;

import gap.client.blservice.expressorderblservice.ExpressOrderService;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.StateVO;
import gap.common.util.ReceiveInfo;
import gap.common.util.ResultMessage;

public class ExpressOrder implements ExpressOrderService {

	PriceCal priceCal;

	public ExpressOrder() {
		// TODO 自动生成的构造函数存根
	}

	public ExpressOrder(PriceCal p) {
		priceCal = p;
	}

	@Override
	public StateVO find(String order_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderVO getOrder(String order_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modify(ExpressOrderVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderVO> getArrivingOrders(String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderVO> getCurrentOrders(String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setArrivedOrders(List<ExpressOrderVO> orders,
			String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setOffOders(List<ExpressOrderVO> orders, String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderVO createOrder(ExpressOrderVO order_info) {
		// TODO 自动生成的方法存根
		order_info.setPrice(priceCal.getPrice(order_info));
		return order_info;
	}

	@Override
	public ResultMessage save(ExpressOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage receiveOrder(String order_id, ReceiveInfo receiveInfo) {
		// TODO 自动生成的方法存根
		return null;
	}

}
