package gap.client.datacontroller.expressorderdata;

import gap.client.util.LocalInfo;
import gap.common.dataservice.ServiceName;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.ExpressOrderModifyPO;
import gap.common.po.ExpressOrderPO;
import gap.common.po.PricePO;
import gap.common.util.CurrentOrderType;
import gap.common.util.ReceiveInfo;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ExpressOrderDataController {
	private final UserType[] users = { UserType.DELIVERY, UserType.MANAGER };
	ExpressOrderDataService expressOrderData;
	PriceDataService priceDataService;

	public ExpressOrderDataController() {
		try {
			expressOrderData = (ExpressOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.EXPRESSORDER_DATA_SERVICE);
			priceDataService = (PriceDataService) Naming.lookup(RMIConfig.url
					+ ServiceName.PRICE_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public ResultMessage add(ExpressOrderPO po) {
		// TODO 自动生成的方法存根
		try {
			return expressOrderData.add(po, LocalInfo.localuser.getUserId());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public PricePO findPrice(String city) {
		try {
			return priceDataService.find(city);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ExpressOrderPO findExpressOrder(String order_id) {
		// TODO 自动生成的方法存根
		try {
			return expressOrderData.find(order_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage modify(ExpressOrderModifyPO po) {
		// TODO 自动生成的方法存根
		try {
			return expressOrderData.modify(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<ExpressOrderPO> findArrivingOrders(String ins_id) {
		// TODO 自动生成的方法存根
		try {
			return expressOrderData.findArrivingOrders(ins_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public List<ExpressOrderPO> findCurrentOrders(String ins_id,
			CurrentOrderType type) {
		// TODO 自动生成的方法存根
		try {
			return expressOrderData.findCurrentOrders(ins_id, type);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getState(String order_id) {
		try {
			return expressOrderData.getState(order_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage setReceived(String order_id, ReceiveInfo info) {
		try {
			return expressOrderData.setRecieved(order_id, info);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

}
