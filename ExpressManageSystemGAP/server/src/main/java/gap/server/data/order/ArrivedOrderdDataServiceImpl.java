package gap.server.data.order;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ResultMessage;
import gap.server.initial.NetModule;

public class ArrivedOrderdDataServiceImpl extends UnicastRemoteObject implements
		ArrivedOrderDataService {

	public ArrivedOrderdDataServiceImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ResultMessage add(ArrivedOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String order_id = "'" + po.getId() + "'";
			ArrayList<String> orders = new ArrayList<String>();
			for (ExpressOrderPO express : po.getOrders()) {
				orders.add(express.getOrder_id());
			}
			String express_order;
			String SQL = "INSERT into arrivedorder (order_id,expressorder_id) VALUSE ("
					+ order_id + ",%s" + ");";
			for (String str : orders)
				NetModule.excutor.excute(String.format(SQL, str));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return null;
	}

	public ArrivedOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
