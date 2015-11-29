package gap.server.data.order;

import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.SQLBuilder;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockoutOrderDataServiceImpl extends UnicastRemoteObject implements
		StockoutOrderDataService {
	// 表名
	private String stockoutTable = "stockoutorder";
	// 字段
	private String order_id_f = "order_id", time_f = "time",
			transport_f = "transport", target_ins_f = "target_ins",
			ins_id_f = "ins_id",passed_f = "passed";
	// 表名
	private String stockoutItemTable = "stockoutitem";
	// 字段
	private String id_f = "id", expressorder_id_f = "expressorder_id",
			orderId_f = "order_id";

	private InsertSQL orderInsert, itemInsert;
	private UpdateSQL update;
	
	public static StockoutOrderDataService instance;

	public StockoutOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		orderInsert = new InsertSQL(stockoutTable);
		itemInsert = new InsertSQL(stockoutItemTable);
		update = new UpdateSQL(stockoutTable);
	}
	
	public static StockoutOrderDataService getInstance() throws RemoteException {
		if (instance == null)
			instance = new StockoutOrderDataServiceImpl();
		return instance;
	}

	@Override
	public ResultMessage add(StockoutOrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String order_id = po.getId(), target_ins = po.getTarget_ins(), time = po
				.getOutDate(), transport = po.getTransport(), ins_id = po
				.getIns_id();
		List<String> expressorder_ids = po.getExpressorder_ids();
		
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE order_id='"
							+ order_id + "';");
			if (re.next()) {
				System.out.println(" 出库单号为" + order_id + "的出库单已经存在");
				return ResultMessage.EXITED;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}


		try {
			orderInsert.clear();
			orderInsert.add(order_id_f, order_id);
			orderInsert.add(transport_f, transport);
			orderInsert.add(target_ins_f, target_ins);
			orderInsert.add(time_f, time);
			orderInsert.add(ins_id_f, ins_id);
			orderInsert.add(passed_f,"false");
			NetModule.excutor.excute(orderInsert.createSQL());
			for (String str : expressorder_ids) {
				itemInsert.clear();
				itemInsert.add(expressorder_id_f, str);
				itemInsert.add(orderId_f, order_id);
				NetModule.excutor.excute(itemInsert.createSQL());
			}
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("入库单增加失败");

		}
		return ResultMessage.FAILED;

	}
	
	public ResultMessage delete(String order_id){
		SQLBuilder sql = new SQLBuilder();
		sql.DeleteFrom(stockoutTable).Where(order_id_f).EQUALS(order_id).excute();
		sql.DeleteFrom(stockoutItemTable).Where(orderId_f).EQUALS(order_id).excute();
		System.out.println("删除了");
		return ResultMessage.SUCCEED;
		
	}

	@Override
	public StockoutOrderPO find(String order_id,String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM stockoutorder WHERE order_id = '"
							+ order_id +"' AND "+ins_id_f+" ='"+ins_id+ "';");
			if(re.next()){
				return getByResultSet(re);
			}else{
				System.out.println("出库单号为" + order_id + "的出库单没找到");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出库单号为" + order_id + "的出库单获取失败");
			e.printStackTrace();
		}
		return null;
	}

	public StockoutOrderPO getByResultSet(ResultSet re) {
		try {
			String transport = re.getString(transport_f);
			String target_ins = re.getString(target_ins_f);
			String outDate = re.getString(time_f);
			String ins_id = re.getString(ins_id_f);
			String order_id = re.getString(order_id_f);
			
			List<String> order_ids = getidsByOrderId(order_id);
			
			StockoutOrderPO po = new StockoutOrderPO(order_ids, outDate,
					target_ins, order_id, transport, ins_id);
			
			return po;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getidsByOrderId(String order_id) {
		try {
			List<String> order_ids = new ArrayList<String>();
			ResultSet itemre = NetModule.excutor.excuteQuery("SELECT * FROM "
					+ stockoutItemTable + " WHERE order_id = '" + order_id
					+ "';");

			while (itemre.next()) {
				String id = itemre.getString(expressorder_id_f);
				order_ids.add(id);
			}
			return order_ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<StockoutOrderPO> getOneDay(String date, String ins_id)
			throws RemoteException {
		// TODO Auto-generated method stub

		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE ins_id ='"
							+ ins_id + "' AND time ='" + date + "';");
			List<StockoutOrderPO> stockoutOrders = new ArrayList<StockoutOrderPO>();
			while (re.next()) {
				StockoutOrderPO po = getByResultSet(re);
				stockoutOrders.add(po);
			}
			return stockoutOrders;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("中转中心" + ins_id + "," + date + "号的出库单获取失败");
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public List<StockoutOrderPO> getRequired(String beginDate, String endDate,
			String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE ins_id = '"
							+ ins_id + "' AND time >= '" + beginDate
							+ "'AND time<= '" + endDate + "';");
			ArrayList<StockoutOrderPO> stockoutOrders = new ArrayList<StockoutOrderPO>();
			while (re.next()) {
				StockoutOrderPO po = getByResultSet(re);
				stockoutOrders.add(po);
			}
			return stockoutOrders;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("中转中心" + ins_id + "," + beginDate + "号到"
					+ endDate + "号的出库单获取失败");
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public ResultMessage setPassed(String order_id, String state_info)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			update.clear();
			update.add(passed_f, "true");
			update.setKey(order_id_f, order_id);
			NetModule.excutor.excute(update.createSQL());
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
	
	public ResultMessage setUnPassed(String order_id, String state_info)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			update.clear();
			update.add(passed_f, "false");
			update.setKey(order_id_f, order_id);
			NetModule.excutor.excute(update.createSQL());
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	@Override
	public List<StockoutOrderPO> getUnpassedOrders() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM " + stockoutTable + " WHERE " + passed_f
					+ " = 'false' ;";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			List<StockoutOrderPO> orders = new ArrayList<StockoutOrderPO>();
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
