package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.DeliveryOrderPO;
import gap.common.util.ResultMessage;

public interface DeliveryOrderDataService extends Remote {
	public ResultMessage add(DeliveryOrderPO po) throws RemoteException;

	public DeliveryOrderPO find(String order_id) throws RemoteException;
}
