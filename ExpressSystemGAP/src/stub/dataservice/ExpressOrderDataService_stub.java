package stub.dataservice;

import java.util.List;

import po.ExpressOrderPO;
import po.ResultMessage;
import dataservice.expressorderdataservice.ExpressOrderDataService;

public class ExpressOrderDataService_stub implements ExpressOrderDataService{

	@Override
	public ResultMessage add(ExpressOrderPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderPO find(String order_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modify(ExpressOrderPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findArrivingOrders(String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findCurrentOrders(String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findLoadOrders(String loadorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findDeliveryOrders(String deliveryorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findArrivedOrders(String arrivedorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
