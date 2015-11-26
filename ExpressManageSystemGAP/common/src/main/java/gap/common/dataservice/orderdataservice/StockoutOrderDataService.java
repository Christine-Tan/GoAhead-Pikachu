package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

public interface StockoutOrderDataService extends Remote {
	public ResultMessage add(StockoutOrderPO po) throws RemoteException;

	public StockoutOrderPO find(String order_id,String ins_id) throws RemoteException;

	public List<StockoutOrderPO> getOneDay(String date, String ins_id)
			throws RemoteException;

	public List<StockoutOrderPO> getRequired(String beginDate, String endDate,
			String ins_id) throws RemoteException;

	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException;

	public List<StockoutOrderPO> getUnpassedOrders() throws RemoteException;
}
