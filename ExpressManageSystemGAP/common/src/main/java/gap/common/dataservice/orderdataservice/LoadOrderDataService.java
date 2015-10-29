package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.LoadOrderPO;
import gap.common.util.ResultMessage;

public interface LoadOrderDataService extends Remote {
	public ResultMessage add(LoadOrderPO po) throws RemoteException;

	public LoadOrderPO find(String order_id) throws RemoteException;
}
