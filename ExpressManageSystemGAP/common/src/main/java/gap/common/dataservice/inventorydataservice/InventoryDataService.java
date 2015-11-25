package gap.common.dataservice.inventorydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;

public interface InventoryDataService extends Remote {
	public ResultMessage add(GoodsPO expressorder) throws RemoteException;

	public ResultMessage add(List<GoodsPO> expressorders)
			throws RemoteException;

	public ResultMessage delete(String expressorder_id) throws RemoteException;

	public ResultMessage delete(List<String> expressorders_id)
			throws RemoteException;

	public ResultMessage modify(GoodsPO expressorder) throws RemoteException;

	public ResultMessage modify(List<GoodsPO> expressorders)
			throws RemoteException;

	public GoodsPO find(String expressorder_id) throws RemoteException;

	public List<GoodsPO> getAll(String ins_id) throws RemoteException;

	public ResultMessage setAlarm(double alarmValue, String ins_id)
			throws RemoteException;

	public double getAlarm(String ins_id) throws RemoteException;

}
