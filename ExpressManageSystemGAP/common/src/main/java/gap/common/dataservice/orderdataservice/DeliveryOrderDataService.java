package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.DeliveryOrderPO;
import gap.common.util.ResultMessage;

public interface DeliveryOrderDataService extends Remote {
	public ResultMessage add(DeliveryOrderPO po) throws RemoteException;

	public DeliveryOrderPO find(String order_id) throws RemoteException;

	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException;

	public List<DeliveryOrderPO> getUnpassedOrders() throws RemoteException;
}
