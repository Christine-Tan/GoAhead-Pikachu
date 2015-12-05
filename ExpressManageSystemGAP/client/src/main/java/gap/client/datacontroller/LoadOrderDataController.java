package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.LoadOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoadOrderDataController {
	private LoadOrderDataService loadOrder;

	protected LoadOrderDataController() {
		try {
			loadOrder = (LoadOrderDataService) Naming.lookup(RMIConfig.url
					+ ServiceName.LOADORDER_DATA_SERVICE);
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

	public ResultMessage add(LoadOrderPO po) {
		try {
			return loadOrder.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
