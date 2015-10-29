package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

public interface StockinOrderDataService extends Remote {
	public ResultMessage add(StockinOrderPO po) throws RemoteException;

	public StockinOrderPO find(String order_id) throws RemoteException;
}
