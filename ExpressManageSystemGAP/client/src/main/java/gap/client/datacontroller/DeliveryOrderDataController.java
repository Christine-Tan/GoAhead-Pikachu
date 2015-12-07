package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.DeliveryOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static gap.client.datacontroller.NetModule.deliveryorderdataservice;

public class DeliveryOrderDataController {

	protected DeliveryOrderDataController() {
	}

	public ResultMessage add(DeliveryOrderPO po) {
		try {
			return deliveryorderdataservice.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
