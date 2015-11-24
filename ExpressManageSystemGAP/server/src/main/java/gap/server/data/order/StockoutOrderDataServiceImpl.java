package gap.server.data.order;

import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockoutOrderDataServiceImpl extends UnicastRemoteObject implements StockoutOrderDataService{
	//表名
	private String stockoutTable = "stockoutorder";
	//字段
	private String order_id_f = "order_id",time_f = "time",transport_f = "transform",target_ins_f = "target_ins",
			ins_id_f = "ins_id";
	//表名
	private String stockoutItemTable  = "stockoutitem";
	//字段
	private String id_f= "id",expressorder_id_f = "expressorder_id",orderId_f="order_id";
	
	private InsertSQL orderInsert,itemInsert;
	
	public StockoutOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		orderInsert = new InsertSQL(stockoutTable);
		itemInsert = new InsertSQL(stockoutItemTable);
	}

	@Override
	public ResultMessage add(StockoutOrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String order_id = po.getId(),target_ins = po.getTarget_ins(),time = po.getOutDate()
		, transport = po.getTransport(),ins_id = po.getIns_id();
		List<String> expressorder_ids = po.getExpressorder_ids();
		
		try {
			orderInsert.clear();
			orderInsert.add(order_id_f, order_id);
			orderInsert.add(transport_f, transport);
			orderInsert.add(target_ins_f, target_ins);
			orderInsert.add(time_f, time);
			orderInsert.add(ins_id_f,ins_id);
			NetModule.excutor.excute(orderInsert.createSQL());
			for (String str : expressorder_ids) {
				itemInsert.clear();
				itemInsert.add(expressorder_id_f, expressorder_ids);
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

	@Override
	public StockoutOrderPO find(String order_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE order_id = '"+order_id+"';");
			re.next();
			String transport = re.getString(transport_f);
			String target_ins = re.getString(target_ins_f);
			String outDate = re.getString(time_f);
			String ins_id = re.getString(ins_id_f);
			ArrayList<String> order_ids = new ArrayList<String>();
			ResultSet itemre = NetModule.excutor
					.excuteQuery("SELECT *　FROM storkoutitem WHERE order_id = '"+order_id+"';");
			
			while(itemre.next()){
				String id = itemre.getString(expressorder_id_f);
				order_ids.add(id);
			}
			StockoutOrderPO po = new StockoutOrderPO(order_ids, outDate, target_ins, transport, order_id, ins_id);
			return po;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出库单号为"+order_id+"的出库单获取失败");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StockoutOrderPO> getOneDay(String date,String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE ins_id = '"+ins_id
							+"' AND time = '"+date+"';");
			ArrayList<StockoutOrderPO> stockoutOrders = new ArrayList<StockoutOrderPO>();
			while(re.next()){
				String order_id = re.getString(order_id_f);
				String transport = re.getString(transport_f);
				String target_ins = re.getString(target_ins_f);
				ArrayList<String> expressorder_ids = new ArrayList<String>();
				ResultSet itemre = NetModule.excutor
						.excuteQuery("SELECT *　FROM storkoutitem WHERE order_id = '"+order_id+"';");
				
				while(itemre.next()){
					String id = itemre.getString(expressorder_id_f);
					expressorder_ids.add(id);
				}
				StockoutOrderPO po = new StockoutOrderPO(expressorder_ids, date, target_ins, transport, order_id, ins_id);
				stockoutOrders.add(po);
			}
			return stockoutOrders;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("中转中心"+ins_id+","+date+"号的出库单获取失败");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public List<StockoutOrderPO> getRequired(String beginDate, String endDate,String ins_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE ins_id = '"+ins_id
							+"' AND time >= '"+beginDate+"'AND time<= '"+endDate+"';");
			ArrayList<StockoutOrderPO> stockoutOrders = new ArrayList<StockoutOrderPO>();
			while(re.next()){
				String order_id = re.getString(order_id_f);
				String transport = re.getString(transport_f);
				String target_ins = re.getString(target_ins_f);
				String outDate = re.getString(time_f);
				ArrayList<String> experssorder_ids = new ArrayList<String>();
				ResultSet itemre = NetModule.excutor
						.excuteQuery("SELECT *　FROM storkoutitem WHERE order_id = '"+order_id+"';");
				
				while(itemre.next()){
					String id = itemre.getString(expressorder_id_f);
					experssorder_ids.add(id);
				}
				StockoutOrderPO po = new StockoutOrderPO(experssorder_ids, outDate, target_ins, transport, order_id, ins_id);
				stockoutOrders.add(po);
			}
			return stockoutOrders;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("中转中心"+ins_id+","+beginDate+"号到"+endDate+"号的出库单获取失败");
			e.printStackTrace();
			
		}
		return null;
	}

}
