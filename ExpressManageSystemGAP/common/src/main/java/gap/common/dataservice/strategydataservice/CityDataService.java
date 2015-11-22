package gap.common.dataservice.strategydataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.CityPO;
import gap.common.util.ResultMessage;

public interface CityDataService extends Remote{
	
	public CityPO find(String name) throws RemoteException;

	public ResultMessage add(CityPO po) throws RemoteException;

	public List<CityPO>  getAll() throws RemoteException;
}
