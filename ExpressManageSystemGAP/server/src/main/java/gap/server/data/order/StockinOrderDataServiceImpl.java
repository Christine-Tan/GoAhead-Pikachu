package gap.server.data.order;

import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.po.GoodsPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockinOrderDataServiceImpl extends UnicastRemoteObject implements StockinOrderDataService{
		//表名
		private String stockinTable = "stockinorder";
		//字段
		private String order_id_f = "order_id",time_f = "time",ins_id_f = "ins_id";
		//表名
		private String stockinItemTable = "stockinitem";
		//字段
		private String expressorder_id_f = "expressorder_id",orderId_f = "order_id"
				,destination_f = "destination",sector_id_f = "sector_id",location_f = "location";
		
		private InsertSQL orderInsert,itemInsert;

	public StockinOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		orderInsert = new InsertSQL(stockinTable);
		itemInsert = new InsertSQL(stockinItemTable);
		
	}

	@Override
	public ResultMessage add(StockinOrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		String order_id = po.getId(),time = po.getInDate(),ins_id = po.getIns_id();
		List<GoodsPO> goodPOs = po.getGoods();
				
				try {
					orderInsert.clear();
					orderInsert.add(order_id_f, order_id);
					orderInsert.add(time_f, time);
					orderInsert.add(ins_id_f, ins_id);
					NetModule.excutor.excute(orderInsert.createSQL());
					for (GoodsPO goods: goodPOs) {
						itemInsert.clear();
						itemInsert.add(expressorder_id_f, goods.getExpressorder_id());
						itemInsert.add(orderId_f, order_id);
						itemInsert.add(destination_f,goods.getDestination());
						itemInsert.add(sector_id_f,goods.getSector_id());
						itemInsert.add(location_f, goods.getLocation());
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
	public StockinOrderPO find(String order_id,String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockinorder WHERE order_id = '"+order_id+"';");
			re.next();
			String date = re.getString(time_f);
			ArrayList<GoodsPO> goodPOs = new ArrayList<GoodsPO>();
			ResultSet itemre = NetModule.excutor
					.excuteQuery("SELECT *　FROM storkinitem WHERE order_id = '"+order_id+"';");
			
			while(itemre.next()){
				String id = itemre.getString(expressorder_id_f),destination = itemre.getString(destination_f),
						sector_id = itemre.getString(sector_id_f),location = itemre.getString(location_f);
				GoodsPO goods = new GoodsPO(id, location, null, date, sector_id, null, destination);
				goodPOs.add(goods);
			}
			StockinOrderPO po = new StockinOrderPO(goodPOs, date, order_id, ins_id);
			return po;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("入库单号为"+order_id+"的入库单获取失败");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StockinOrderPO> getOneDay(String date,String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockinorder WHERE ins_id = '"+ins_id
							+"' AND time = '"+date+"';");
			ArrayList<StockinOrderPO> stockinOrders = new ArrayList<StockinOrderPO>();
			while(re.next()){
				String order_id = re.getString(order_id_f);
				ArrayList<GoodsPO> goodPOs = new ArrayList<GoodsPO>();
				ResultSet itemre = NetModule.excutor
						.excuteQuery("SELECT *　FROM storkinitem WHERE order_id = '"+order_id+"';");
				
				while(itemre.next()){
					String id = itemre.getString(expressorder_id_f),destination = itemre.getString(destination_f),
							sector_id = itemre.getString(sector_id_f),location = itemre.getString(location_f);
					GoodsPO goods = new GoodsPO(id, location, null, date, sector_id, null, destination);
					goodPOs.add(goods);
				}
				StockinOrderPO po = new StockinOrderPO(goodPOs, date, order_id, ins_id);
				stockinOrders.add(po);
			}
			return stockinOrders;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("中转中心"+ins_id+","+date+"号的入库单获取失败");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public List<StockinOrderPO> getRequired(String beginDate, String endDate,String ins_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT * FROM stockoutorder WHERE ins_id = '"+ins_id
							+"' AND time >= '"+beginDate+"'AND time<= '"+endDate+"';");
			ArrayList<StockinOrderPO> stockinOrders = new ArrayList<StockinOrderPO>();
			while(re.next()){
				String order_id = re.getString(order_id_f);
				String date = re.getString(time_f);
				ArrayList<GoodsPO> goodPOs = new ArrayList<GoodsPO>();
				ResultSet itemre = NetModule.excutor
						.excuteQuery("SELECT *　FROM storkinitem WHERE order_id = '"+order_id+"';");
				
				while(itemre.next()){
					String id = itemre.getString(expressorder_id_f),destination = itemre.getString(destination_f),
							sector_id = itemre.getString(sector_id_f),location = itemre.getString(location_f);
					GoodsPO goods = new GoodsPO(id, location, null, date, sector_id, null, destination);
					goodPOs.add(goods);
				}
				StockinOrderPO po = new StockinOrderPO(goodPOs, date, order_id, ins_id);
				stockinOrders.add(po);
			}
			return stockinOrders;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("中转中心"+ins_id+","+beginDate+"号到"+endDate+"号的入库单获取失败");
			e.printStackTrace();
			
		}
		return null;
	}

}
