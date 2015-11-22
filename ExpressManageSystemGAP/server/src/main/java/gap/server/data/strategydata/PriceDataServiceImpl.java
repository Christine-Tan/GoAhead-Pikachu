package gap.server.data.strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.po.InstitutionPO;
import gap.common.po.PricePO;
import gap.common.util.ResultMessage;

/**
 * @author seven
 */
public class PriceDataServiceImpl extends UnicastRemoteObject implements PriceDataService{

	public PriceDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public PricePO find(String city_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(PricePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(PricePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
