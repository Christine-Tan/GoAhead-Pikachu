package gap.server.data.order;

import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StockoutOrderDataServiceImpl extends UnicastRemoteObject implements StockoutOrderDataService{

	protected StockoutOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(StockoutOrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockoutOrderPO find(String order_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockoutOrderPO> get(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockoutOrderPO> getRequired(String beginDate, String endDate)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
