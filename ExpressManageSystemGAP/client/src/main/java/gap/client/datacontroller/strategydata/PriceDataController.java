package gap.client.datacontroller.strategydata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.PricePO;
import gap.common.util.ResultMessage;

/**
 * 
 * @author seven
 *
 */
public class PriceDataController {
	PriceDataService priceData;

	public PriceDataController() {
		try {
			priceData = (PriceDataService) Naming.lookup(RMIConfig.url + ServiceName.PRICE_DATA_SERVICE);
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

	public PricePO find(String city_id) {
		try {
			return priceData.find(city_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(PricePO po) {
		try {
			return priceData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(PricePO po) {
		try {
			return priceData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<PricePO> getAll() {
		try {
			return priceData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
