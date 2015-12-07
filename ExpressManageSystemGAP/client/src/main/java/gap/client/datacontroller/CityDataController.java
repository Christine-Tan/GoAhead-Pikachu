package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;

import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.CityPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import static gap.client.datacontroller.NetModule.citydataservice;

public class CityDataController {

	protected CityDataController() {
	}

	public CityPO find(String name) {
		try {
			return citydataservice.find(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(CityPO po) {
		try {
			return citydataservice.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<CityPO> getAll() {
		try {
			return citydataservice.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
