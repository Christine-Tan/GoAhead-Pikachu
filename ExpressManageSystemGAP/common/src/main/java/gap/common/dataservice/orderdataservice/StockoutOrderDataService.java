package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

public interface StockoutOrderDataService extends Remote {
	public ResultMessage add(StockoutOrderPO po) throws RemoteException;

	public StockoutOrderPO find(String identifier) throws RemoteException;
}
