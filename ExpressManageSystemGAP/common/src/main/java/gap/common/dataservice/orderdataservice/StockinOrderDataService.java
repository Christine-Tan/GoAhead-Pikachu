package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.LoadOrderPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

public interface StockinOrderDataService extends Remote {
	public ResultMessage add(StockinOrderPO po) throws RemoteException;

	public StockinOrderPO find(String order_id, String ins_id)
			throws RemoteException;

	public List<StockinOrderPO> getOneDay(String date, String ins_id)
			throws RemoteException;

	public List<StockinOrderPO> getRequired(String beginDate, String endDate,
			String ins_id) throws RemoteException;

	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException;

	public List<StockinOrderPO> getUnpassedOrders() throws RemoteException;

}
