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
import static gap.client.datacontroller.NetModule.arrivedOrderdataservice;

public class ArrivedOrderDataController {

	protected ArrivedOrderDataController() {
	}

	public ResultMessage add(ArrivedOrderPO po) {
		try {
			return arrivedOrderdataservice.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public int nextId(String cons) {
		try {
			return arrivedOrderdataservice.getMaxId(cons);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return -1;
	}

}
