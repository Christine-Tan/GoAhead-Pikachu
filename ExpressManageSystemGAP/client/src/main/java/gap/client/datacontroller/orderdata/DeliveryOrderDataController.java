package gap.client.datacontroller.orderdata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.DeliveryOrderPO;
import gap.common.util.ResultMessage;

public class DeliveryOrderDataController {
	DeliveryOrderDataService deliveryOrder;

	public DeliveryOrderDataController() {
		try {
			deliveryOrder = (DeliveryOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.DELIVERYPORDER_DATA_SERVICE);
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

	public ResultMessage add(DeliveryOrderPO po) {
		try {
			return deliveryOrder.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
