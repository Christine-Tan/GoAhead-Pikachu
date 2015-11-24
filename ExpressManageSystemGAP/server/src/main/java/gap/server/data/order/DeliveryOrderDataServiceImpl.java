package gap.server.data.order;

import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.po.DeliveryOrderPO;
import gap.common.po.LoadOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.expressorder.ExpressOrderDataServiceImpl;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeliveryOrderDataServiceImpl extends UnicastRemoteObject implements
		DeliveryOrderDataService {

	private String tableName = "deliveryorder",
			itemTable = "deliveryorderitem";
	private String order_id_f = "order_id", comment_f = "comment",
			time_f = "time", passed_f = "passed";
	private String item_id_expressorder_f = "expressorder_id",
			item_order_id_f = "order_id", item_delivery_id_f = "delivery_id";
	private InsertSQL orderInsert, itemInsert;
	private UpdateSQL update;

	public DeliveryOrderDataServiceImpl() throws RemoteException {
		super();
		orderInsert = new InsertSQL(tableName);
		itemInsert = new InsertSQL(itemTable);
		update = new UpdateSQL(tableName);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public ResultMessage add(DeliveryOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String order_id = po.getId(), comment = po.getComment(), time = po
					.getTime();
			orderInsert.clear();
			orderInsert.add(order_id_f, order_id);
			orderInsert.add(comment_f, comment);
			orderInsert.add(time_f, time);
			NetModule.excutor.excute(orderInsert.createSQL());
			Map<String, List<String>> orders = po.getDeliveryInfo();
			Set<String> sets = orders.keySet();
			for (String str : sets) {
				for (String str1 : orders.get(str)) {
					itemInsert.clear();
					itemInsert.add(item_order_id_f, order_id);
					itemInsert.add(item_id_expressorder_f, str1);
					itemInsert.add(item_delivery_id_f, str);
					NetModule.excutor.excute(itemInsert.createSQL());
				}
			}
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	@Override
	public DeliveryOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	private DeliveryOrderPO getByResultSet(ResultSet re) {
		try {
			String order_id = re.getString(order_id_f), time = re
					.getString(time_f), comment = re.getString(comment_f);
			Map<String, List<String>> orders = getByOrder_id(order_id);
			DeliveryOrderPO po = new DeliveryOrderPO(orders, time, order_id,
					comment);
			return po;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return null;
	}

	private Map<String, List<String>> getByOrder_id(String order_id) {
		try {
			String sql = "SELECT * FROM " + itemTable + " WHERE "
					+ item_order_id_f + " = " + order_id + " GROUP BY "
					+ item_delivery_id_f + ";";
			Map<String, List<String>> result = new HashMap<String, List<String>>();
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			while (re.next()) {
				String delivery_id = re.getString(item_delivery_id_f);
				List<String> orders = getByDelivery_id(delivery_id, order_id);
				result.put(delivery_id, orders);
			}
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	private List<String> getByDelivery_id(String delivery_id, String order_id) {
		try {
			String sql = "SELECT * FROM " + itemTable + " WHERE "
					+ item_order_id_f + " = " + order_id + " AND "
					+ item_delivery_id_f + " = " + delivery_id + ";";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			List<String> orders = new ArrayList<String>();
			while (re.next())
				orders.add(re.getString(item_id_expressorder_f));
			return orders;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DeliveryOrderPO> getUnpassedOrders() throws RemoteException {
		// TODO 自动生成的方法存根

		try {
			String sql = "SELECT * FROM " + tableName + " WHERE " + passed_f
					+ " = false ;";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			List<DeliveryOrderPO> orders = new ArrayList<>();
			while (re.next()) {
				orders.add(getByResultSet(re));
			}
			return orders;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
