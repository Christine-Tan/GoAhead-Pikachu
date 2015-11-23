package gap.server.data.order;

import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StockinOrdreDataServiceImpl extends UnicastRemoteObject implements StockinOrderDataService{
		//表名
		private String stockinTable = "stockinorder";
		//字段
		private String order_id_f = "order_id";
		//表名
		private String stockinItemTable = "stockinitem";
		//字段
		private String a = "";

	protected StockinOrdreDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public ResultMessage add(StockinOrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockinOrderPO find(String order_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockinOrderPO> get(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockinOrderPO> getRequired(String beginDate, String endDate)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
