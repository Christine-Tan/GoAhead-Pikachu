package gap.server.data.strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.po.CityPO;
import gap.common.po.InstitutionPO;
import gap.common.util.ResultMessage;

public class CityDataServiceImpl extends UnicastRemoteObject implements CityDataService{

	public CityDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CityPO find(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
