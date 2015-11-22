package gap.server.data.inventorydata;

import gap.common.dataservice.inventorydataservice.InventoryDataService;
import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class InventoryDataServiceImpl extends UnicastRemoteObject implements InventoryDataService{
	//表名
	private String tableName = "institution";
	//字段
	private String id_f = "ins_id", insname_f = "name", memberNum_f = "memberNum", address_f = "address",
			instype_f = "ins_type";
	
	
	private InsertSQL insertSQL;
	private UpdateSQL updateSQL;
	
	protected InventoryDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		insertSQL = new InsertSQL(tableName);
		updateSQL = new UpdateSQL(tableName);
	}

	@Override
	public ResultMessage add(GoodsPO expressorder) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(List<GoodsPO> expressorders)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String expressorder_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(List<String> expressorders_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(GoodsPO expressorder) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(List<GoodsPO> expressorders)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsPO find(String expressorder_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setAlarm(double alarmValue) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAlarm() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
