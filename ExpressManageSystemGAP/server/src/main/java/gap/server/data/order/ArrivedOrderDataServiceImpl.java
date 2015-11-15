package gap.server.data.order;

import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArrivedOrderDataServiceImpl extends UnicastRemoteObject implements
		ArrivedOrderDataService {
	private String tableName = "arrivedorder";
	private String order_id_f = "order_id",
			expressorder_id_f = "expressorder_id";
	private InsertSQL insertSQL;

	public ArrivedOrderDataServiceImpl() throws RemoteException {
		super();
		insertSQL = new InsertSQL(tableName);
	}

	public ResultMessage add(ArrivedOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String order_id = po.getId();
			ArrayList<String> orders = new ArrayList<String>();
			for (ExpressOrderPO express : po.getOrders()) {
				orders.add(express.getOrder_id());
			}
			for (String str : orders) {
				insertSQL.clear();
				insertSQL.add(order_id_f, order_id);
				insertSQL.add(expressorder_id_f, str);
				String sql = insertSQL.createSQL();
				NetModule.excutor.excute(sql);
			}
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
