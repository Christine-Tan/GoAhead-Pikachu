package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.ArrivedOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ArrivedOrderDataController {
	ArrivedOrderDataService arrivedOrderData;

	protected ArrivedOrderDataController() {
		try {
			arrivedOrderData = (ArrivedOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.ARRIVEDORDER_DATA_SERVICE);
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

	public ResultMessage add(ArrivedOrderPO po) {
		try {
			return arrivedOrderData.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
