package gap.client.datacontroller.expressorderdata;

import gap.client.util.LocalInfo;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.po.ExpressOrderModifyPO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

import java.rmi.RemoteException;
import java.util.List;

public class ExpressOrderDataController {
	private final UserType[] users = { UserType.DELIVERY, UserType.MANAGER };
	ExpressOrderDataService expressOrderData;
	PriceDataService priceDataService;

	public ExpressOrderDataController() {

	}

	public ResultMessage add(ExpressOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return expressOrderData.add(po, LocalInfo.localuser.getUser_id());
	}

	public ExpressOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return expressOrderData.find(order_id);
	}

	public ResultMessage modify(ExpressOrderModifyPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return expressOrderData.modify(po);
	}

	public List<ExpressOrderPO> findArrivingOrders(String ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return expressOrderData.findArrivingOrders(ins_id);
	}

	public List<ExpressOrderPO> findCurrentOrders(String ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<ExpressOrderPO> findLoadOrders(String loadorder_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<ExpressOrderPO> findDeliveryOrders(String deliveryorder_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<ExpressOrderPO> findArrivedOrders(String arrivedorder_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
