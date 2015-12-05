package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.RentPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class RentDataController {
	RentDataService rentData;

	protected RentDataController() {
		try {
			rentData = (RentDataService) Naming.lookup(RMIConfig.url + ServiceName.RENT_DATA_SERVICE);
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

	public List<RentPO> getAll() {
		try {
			return rentData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(RentPO po) {
		try {
			return rentData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(RentPO po) {
		try {
			return rentData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage setPaid(String institution) {
		try {
			return rentData.setPaid(institution);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
