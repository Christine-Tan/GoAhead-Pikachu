package gap.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

public interface StockinOrderDataService extends Remote {
	public ResultMessage add(StockinOrderPO po) throws RemoteException;

	public StockinOrderPO find(String order_id) throws RemoteException;
	
	/**
	 * 查找某天的入库单 
	 * @param date
	 * @return
	 * @throws RemoteException
	 */
	public List<StockinOrderPO> get(String date) throws RemoteException;
	
	/**
	 * 查找某几天的入库单
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws RemoteException
	 */
	public List<StockinOrderPO> getRequired(String beginDate,String endDate) throws RemoteException;
	
	
}
