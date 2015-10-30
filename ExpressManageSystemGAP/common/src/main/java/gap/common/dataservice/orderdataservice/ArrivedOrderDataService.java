package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.ArrivedOrderPO;
import gap.common.util.ResultMessage;

public interface ArrivedOrderDataService extends Remote {
	public ResultMessage add(ArrivedOrderPO po) throws RemoteException;

	public ArrivedOrderPO find(String order_id) throws RemoteException;
}
