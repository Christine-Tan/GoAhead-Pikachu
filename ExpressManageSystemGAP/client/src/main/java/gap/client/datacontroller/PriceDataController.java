package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.PricePO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import static gap.client.datacontroller.NetModule.pricedataservice;

/**
 * 
 * @author seven
 *
 */
public class PriceDataController {

	protected PriceDataController() {
	}

	public PricePO find(String city) {
		try {
			return pricedataservice.find(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(PricePO po) {
		try {
			return pricedataservice.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(PricePO po) {
		try {
			return pricedataservice.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<PricePO> getAll() {
		try {
			return pricedataservice.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
