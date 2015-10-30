package gap.common.dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.DistancePO;
import gap.common.util.ResultMessage;

public interface DistanceDataService extends Remote {
	public DistancePO find(String startCity, String endCity)
			throws RemoteException;

	public ResultMessage add(DistancePO po) throws RemoteException;

	public ResultMessage modify(DistancePO po) throws RemoteException;
}
