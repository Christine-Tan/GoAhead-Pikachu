package gap.server.data.order;

import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.po.ArrivedOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.expressorder.ExpressOrderDataServiceImpl;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class ArrivedOrderDataServiceImpl extends UnicastRemoteObject implements
		ArrivedOrderDataService {
	private String tableName = "arrivedorder", itemTable = "arrivedorderitem";
	private String order_id_f = "order_id", des_insid_f = "des_ins_id",
			from_ins_id_f = "from_ins_id", comment_f = "comment",
			time_f = "time", passed_f = "passed";
	private String item_id_expressorder_f = "expressorder_id",
			item_order_id_f = "order_id", item_arrivedstate_f = "arrivedstate";
	private InsertSQL orderInsert, itemInsert;
	private UpdateSQL update;

	public ArrivedOrderDataServiceImpl() throws RemoteException {
		super();
		orderInsert = new InsertSQL(tableName);
		itemInsert = new InsertSQL(itemTable);
		update = new UpdateSQL(tableName);
	}

	public ResultMessage add(ArrivedOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String order_id = po.getId(), des_ins = po.getDes_ins_id(), from_ind = po
					.getFrom_ins_id(), comment = po.getComment(), time = po
					.getTime();
			orderInsert.clear();
			orderInsert.add(order_id_f, order_id);
			orderInsert.add(des_insid_f, des_ins);
			orderInsert.add(from_ins_id_f, from_ind);
			orderInsert.add(comment_f, comment);
			orderInsert.add(time_f, time);
			NetModule.excutor.excute(orderInsert.createSQL());
			Map<String, String> orders = po.getOrders();
			Set<String> sets = orders.keySet();
			for (String str : sets) {
				itemInsert.clear();
				itemInsert.add(item_order_id_f, order_id);
				itemInsert.add(item_id_expressorder_f, str);
				itemInsert.add(item_arrivedstate_f, orders.get(str));
				NetModule.excutor.excute(itemInsert.createSQL());
			}
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ArrivedOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			update.clear();
			update.add(passed_f, true);
			update.setKey(order_id_f, order_id);
			NetModule.excutor.excute(update.createSQL());
			String sql = "SELECT * FROM " + itemTable + " WHERE "
					+ item_order_id_f + " = " + order_id + ";";
			ExpressOrderDataService orderData = ExpressOrderDataServiceImpl
					.getInstance();
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			while (re.next()) {
				orderData.setArrived(re.getString(item_id_expressorder_f),
						order_id.substring(0, 7), state_info);
			}
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

}
