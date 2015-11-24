package gap.server.data.order;

import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.po.LoadOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class LoadOrderDataServiceImpl extends UnicastRemoteObject implements
		LoadOrderDataService {
	private String tableName = "loadorder", itemTable = "loadorderitem";
	private String order_id_f = "order_id", driver_id_f = "driver_id",
			guard_id_f = "guard_id", car_num_f = "car_num", time_f = "time";
	private String item_expressorder_id_f = "expressorder_id",
			item_order_id_f = "order_id";
	private InsertSQL orderInsert, itemInsert;

	public LoadOrderDataServiceImpl() throws RemoteException {
		orderInsert = new InsertSQL(tableName);
		itemInsert = new InsertSQL(itemTable);
	}

	@Override
	public ResultMessage add(LoadOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String order_id = po.getOrder_id(), driver_id = po.getDriver_id(), guard_id = po
					.getGuard_id(), car_num = po.getCar_number();
			String time = po.getDate();
			orderInsert.clear();
			orderInsert.add(order_id_f, order_id);
			orderInsert.add(driver_id_f, driver_id);
			orderInsert.add(guard_id_f, guard_id);
			orderInsert.add(car_num_f, car_num);
			orderInsert.add(time_f, time);
			NetModule.excutor.excute(orderInsert.createSQL());
			List<String> orders = po.getOrders();
			for (String str : orders) {
				itemInsert.clear();
				itemInsert.add(item_expressorder_id_f, str);
				itemInsert.add(item_order_id_f, order_id);
				NetModule.excutor.excute(itemInsert.createSQL());
			}
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	@Override
	public LoadOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
