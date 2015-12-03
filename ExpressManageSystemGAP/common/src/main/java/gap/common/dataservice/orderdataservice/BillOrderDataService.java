package gap.common.dataservice.orderdataservice;

import gap.common.po.ArrivedOrderPO;
import gap.common.po.BillOrderPO;
import gap.common.util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BillOrderDataService extends Remote {
	public ResultMessage add(BillOrderPO po) throws RemoteException;

	public BillOrderPO find(String order_id) throws RemoteException;

	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException;

	public List<BillOrderPO> getUnpassedOrders() throws RemoteException;

	public int getMaxId(String cons) throws RemoteException;

}
