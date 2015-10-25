package stub.blservice;

import java.util.List;

import stub.dataservice.ExpressOrderDataService_stub;
import util.ReceiveInfo;
import util.ResultMessage;
import client.blservice.expressorderblservice.ExpressOrderService;
import client.vo.ExpressOrderVO;
import client.vo.StateVO;

public class ExpressOrderService_stub implements ExpressOrderService {

	private ExpressOrderDataService_stub datastub;

	public ExpressOrderService_stub() {
		datastub = new ExpressOrderDataService_stub();
	}

	@Override
	public StateVO getState(String order_id) {
		// TODO 自动生成的方法存根
		return new StateVO();
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
		return null;
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
