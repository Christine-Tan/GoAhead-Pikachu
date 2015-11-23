package gap.server.data.expressorder;

import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.po.ExpressOrderPO;
import gap.common.util.Address;
import gap.common.util.CargoInfo;
import gap.common.util.ExpressType;
import gap.common.util.PeopleInfo;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.SelectSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpressOrderDataServiceImpl implements ExpressOrderDataService {
	// 插入语句生成器
	private InsertSQL senderInsert, receiverInsert, orderInsert, cargoInsert,
			addressInsert, stateInsert;
	// 表名
	private String senderTable = "sender_info",
			receiverTable = "receiver_info", cargoTable = "cargo_info",
			addressTable = "address", stateTable = "expressorderstate",
			tableName = "expressorder";
	// expressorder表字段名
	private String order_id_f = "order_id", current_ins_id_f = "currentIns_id",
			sender_info_f = "sender_info", receiver_info_f = "receiver_info",
			order_type_f = "order_type", cargo_info_f = "cargo_info",
			price_f = "price", delivery_id_f = "delivery_id",
			create_time_f = "create_time";
	// sender_info 和 receiver_info 表字段名
	private String info_name_f = "name", info_phone_f = "phone",
			info_depart_f = "department", info_address_f = "address";
	// cargo_info 表字段名
	private String cargo_name_f = "cargoName", cargo_num_f = "numbers",
			cargo_weight_f = "weight", cargo_volume = "volume";
	// address表字段名
	private String add_id_f = "id", add_province_f = "province",
			add_district_f = "district", add_city_f = "city";
	// state 表字段名
	private String state_id_f = "order_id", state_time_f = "state_time",
			state_state_f = "state";

	public ExpressOrderDataServiceImpl() {
		senderInsert = new InsertSQL(senderTable);
		receiverInsert = new InsertSQL(receiverTable);
		cargoInsert = new InsertSQL(cargoTable);
		orderInsert = new InsertSQL(tableName);
		addressInsert = new InsertSQL(addressTable);
		stateInsert = new InsertSQL(stateTable);
	}

	/**
	 * 添加订单
	 */
	@Override
	public ResultMessage add(ExpressOrderPO po, String courier_id)
			throws RemoteException {
		// TODO 自动生成的方法存根

		try {
			PeopleInfo sender = po.getSenderInfo(), receiver = po
					.getReceiverInfo();
			CargoInfo cargo = po.getCargoInfo();
			String order_id = po.getOrder_id(), current_ins_id = po
					.getCurrentins_id();
			ExpressType type = po.getExpressType();
			double price = po.getPrice();

			// 判断对应订单号是否已经存在
			String sele = "SELECT * FROM expressorder WHERE order_id="
					+ order_id + ";";
			ResultSet re = NetModule.excutor.excuteQuery(sele);
			if (re.next()) {
				System.out
						.println("Expressorder Exist!!\nOrder_id:" + order_id);
				return ResultMessage.EXITED;
			}

			int sender_id, receiver_id, cargo_id;

			if (((sender_id = saveSenderinfo(sender)) == -1)
					|| ((receiver_id = saveReceiverinfo(receiver)) == -1)
					|| ((cargo_id = saveCargoInfo(cargo)) == -1))
				return ResultMessage.FAILED;

			orderInsert.clear();
			orderInsert.add(sender_info_f, sender_id);
			orderInsert.add(receiver_info_f, receiver_id);
			orderInsert.add(cargo_info_f, cargo_id);
			orderInsert.add(price_f, price);
			orderInsert.add(order_id_f, order_id);
			orderInsert.add(current_ins_id_f, current_ins_id);
			orderInsert.add(order_type_f, type);
			orderInsert.add(delivery_id_f, courier_id);
			orderInsert
					.add(create_time_f, new Date(System.currentTimeMillis()));
			String sql = orderInsert.createSQL();
			NetModule.excutor.excute(sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	/**
	 * 根据订单号查找单一订单
	 */
	@Override
	public ExpressOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String sql = "SELECT * FROM expressorder WHERE order_id="
					+ order_id + ";";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			re.next();
			return getByResultSet(re);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage modify(ExpressOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		PeopleInfo sender = po.getSenderInfo(), receiver = po.getReceiverInfo();
		CargoInfo cargo = po.getCargoInfo();
		String order_id = po.getOrder_id(), current_ins_id = po
				.getCurrentins_id(), targetins_id = po.getTargetins_id();
		ExpressType type = po.getExpressType();
		double price = po.getPrice();
		return null;
	}

	/**
	 * 获得即将到达的订单
	 */
	@Override
	public List<ExpressOrderPO> findArrivingOrders(String ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<ExpressOrderPO> orders = new ArrayList<ExpressOrderPO>();
			String sql = "SELECT * FROM expressorder WHERE targetIns_id="
					+ ins_id + ";";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
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

	@Override
	public List<ExpressOrderPO> findCurrentOrders(String ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<ExpressOrderPO> orders = new ArrayList<ExpressOrderPO>();
			String sql = "SELECT * FROM expressorder WHERE currentIns_id="
					+ ins_id + ";";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
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

	@Override
	public List<ExpressOrderPO> findLoadOrders(String loadorder_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findDeliveryOrders(String deliveryorder_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findArrivedOrders(String arrivedorder_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addState(String order_id, String state) {
		try {
			stateInsert.clear();
			stateInsert.add(state_id_f, order_id);
			stateInsert.add(state_state_f, state);
			String sql = stateInsert.createSQL();
			NetModule.excutor.excute(sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	@Override
	public List<String> getState(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			String sql = "SELECT * FROM " + stateTable + " WHERE order_id="
					+ order_id + " ORDER BY " + state_time_f + ";";
			ResultSet re = NetModule.excutor.excuteQuery(sql);
			List<String> states = new ArrayList<String>();
			while (re.next()) {
				states.add(re.getString(state_state_f));
			}
			return states;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过结果集获得订单信息
	 * @param re
	 * @return
	 */
	private ExpressOrderPO getByResultSet(ResultSet re) {
		try {
			String order_id = re.getString(order_id_f);
			ExpressType type = ExpressType.valueOf(re.getString(order_type_f));
			double price = re.getDouble(price_f);
			int sender_id = re.getInt(sender_info_f), receiver_id = re
					.getInt(receiver_info_f), cargo_id = re
					.getInt(cargo_info_f);
			PeopleInfo sender = getPeopleInfo(sender_id, senderTable), receiver = getPeopleInfo(
					receiver_id, receiverTable);
			CargoInfo cargo = getCargo(cargo_id);
			ExpressOrderPO order = new ExpressOrderPO(sender, receiver, type,
					cargo, order_id, price);
			return order;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得寄件人或收件人信息
	 * @param id
	 * @param tableName
	 * @return
	 */
	private PeopleInfo getPeopleInfo(int id, String tableName) {
		try {
			String sql = "SELECT * FROM " + tableName + " WHERE id= " + id
					+ ";";
			ResultSet re;
			re = NetModule.excutor.excuteQuery(sql);
			re.next();
			String name = re.getString(info_name_f), phone = re
					.getString(info_phone_f), department = re
					.getString(info_depart_f);
			Address address = getAddress(re.getInt(info_address_f));
			PeopleInfo people = new PeopleInfo(name, address, department, phone);
			return people;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得地址信息
	 * @param id
	 * @return
	 */
	private Address getAddress(int id) {
		try {
			String sql = "SELECT * FROM " + addressTable + " WHERE id= " + id
					+ ";";
			ResultSet re;
			re = NetModule.excutor.excuteQuery(sql);
			re.next();
			String province = re.getString(add_province_f), city = re
					.getString(add_city_f), distric = re
					.getString(add_district_f);
			Address add = new Address(province, city, distric);
			return add;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得货物信息
	 * @param id
	 * @return
	 */
	private CargoInfo getCargo(int id) {
		try {
			String sql = "SELECT * FROM " + cargoTable + " WHERE id= " + id
					+ ";";
			ResultSet re;
			re = NetModule.excutor.excuteQuery(sql);
			re.next();
			String name = re.getString(cargo_name_f);
			int numbers = re.getInt(cargo_num_f);
			double weight = re.getDouble(cargo_weight_f), volumn = re
					.getDouble(cargo_volume);
			CargoInfo cargo = new CargoInfo(numbers, weight, volumn, name);
			return cargo;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 保存寄件人信息
	 * @param info
	 * @return
	 */
	private int saveSenderinfo(PeopleInfo info) {
		try {
			int address_id = saveAddress(info.getAddress());
			senderInsert.clear();
			senderInsert.add(info_name_f, info.getName());
			senderInsert.add(info_address_f, address_id);
			senderInsert.add(info_depart_f, info.getDepart());
			senderInsert.add(info_phone_f, info.getCellphone());
			String sql = senderInsert.createSQL();
			NetModule.excutor.excute(sql);
			String seSql = "SELECT max(id) from " + senderTable + ";";
			ResultSet re = NetModule.excutor.excuteQuery(seSql);
			re.next();
			return re.getInt(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 保存收件人信息
	 * @param info
	 * @return
	 */
	private int saveReceiverinfo(PeopleInfo info) {
		try {
			int address_id = saveAddress(info.getAddress());
			receiverInsert.clear();
			receiverInsert.add(info_name_f, info.getName());
			receiverInsert.add(info_address_f, address_id);
			receiverInsert.add(info_depart_f, info.getDepart());
			receiverInsert.add(info_phone_f, info.getCellphone());
			String sql = receiverInsert.createSQL();
			NetModule.excutor.excute(sql);
			String seSql = "SELECT max(id) from " + receiverTable + ";";
			ResultSet re = NetModule.excutor.excuteQuery(seSql);
			re.next();
			return re.getInt(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 保存货物信息
	 * @param info
	 * @return
	 */
	private int saveCargoInfo(CargoInfo info) {
		try {
			cargoInsert.clear();
			cargoInsert.add(cargo_name_f, info.getName());
			cargoInsert.add(cargo_num_f, info.getCargoNum());
			cargoInsert.add(cargo_weight_f, info.getWeight());
			cargoInsert.add(cargo_volume, info.getVolume());
			String sql = cargoInsert.createSQL();
			NetModule.excutor.excute(sql);
			String seSql = "SELECT max(id) from " + cargoTable + ";";
			ResultSet re = NetModule.excutor.excuteQuery(seSql);
			re.next();
			return re.getInt(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 保存地址信息
	 * @param address
	 * @return
	 */
	public int saveAddress(Address address) {
		try {
			// 若地址表中有对应地址项，则直接返回对应记录id
			SelectSQL sql = new SelectSQL(addressTable);
			sql.addConstraint(add_city_f, address.getCity_name());
			sql.addConstraint(add_province_f, address.getProvince_name());
			sql.addConstraint(add_district_f, address.getDistrict_name());
			ResultSet re = NetModule.excutor.excuteQuery(sql.createSQL());
			if (re.next())
				return re.getInt(add_id_f);
			// 若不存在，这先添加对应id
			addressInsert.clear();
			addressInsert.add(add_city_f, address.getCity_name());
			addressInsert.add(add_district_f, address.getDistrict_name());
			addressInsert.add(add_province_f, address.getProvince_name());
			String inSql = addressInsert.createSQL();
			NetModule.excutor.excute(inSql);

			re = NetModule.excutor.excuteQuery(sql.createSQL());
			re.next();
			return re.getInt(add_id_f);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return -1;
	}

}
