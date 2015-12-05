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

public class CityDataController {
	CityDataService cityData;

	protected CityDataController() {
		try {
			cityData = (CityDataService) Naming.lookup(RMIConfig.url + ServiceName.CITY_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CityPO find(String name) {
		try {
			return cityData.find(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(CityPO po) {
		try {
			return cityData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<CityPO> getAll() {
		try {
			return cityData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
