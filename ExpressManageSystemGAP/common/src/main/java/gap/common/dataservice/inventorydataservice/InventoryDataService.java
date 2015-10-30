package gap.common.dataservice.inventorydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;

public interface InventoryDataService extends Remote {
	public ResultMessage add(GoodsPO expressorder) throws RemoteException;

	public ResultMessage delete(String expressorder_id) throws RemoteException;

	public ResultMessage modify(GoodsPO expressorder) throws RemoteException;

	public GoodsPO find(String expressorder_id) throws RemoteException;

	/**
	 * 设置警戒值
	 * @param alarmValue
	 * @return
	 */
	public ResultMessage setAlarm(double alarmValue) throws RemoteException;

	/**
	 * 获得警戒值
	 * @return
	 */
	public double getAlarm() throws RemoteException;

}
