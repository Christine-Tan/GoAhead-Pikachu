package gap.server.data.expressorder;

import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.po.ExpressOrderPO;
import gap.common.util.Address;
import gap.common.util.CargoInfo;
import gap.common.util.PeopleInfo;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.SelectSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpressOrderDataServiceImpl implements ExpressOrderDataService {
	private InsertSQL senderInsert, receiverInsert, orderInsert, cargoInsert,
			addressInsert;
	private String senderTable = "sender_info",
			receiverTable = "receiver_info", cargoTable = "cargo_info",
			addressTable = "address", tableName = "expressorder";
	private String info_name_f = "name", info_phone_f = "phone",
			info_depart_f = "department", info_address_f = "address";
	private String cargo_name_f = "cargoName", cargo_num_f = "numbers",
			cargo_weight_f = "weight", cargo_volume = "volume";
	private String add_id_f = "id", add_province_f = "province",
			add_district_f = "district", add_city_f = "city";

	public ExpressOrderDataServiceImpl() {
		senderInsert = new InsertSQL(senderTable);
		receiverInsert = new InsertSQL(receiverTable);
		cargoInsert = new InsertSQL(cargoTable);
		orderInsert = new InsertSQL(tableName);
		addressInsert = new InsertSQL(addressTable);
	}

	@Override
	public ResultMessage add(ExpressOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderPO find(String order_id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modify(ExpressOrderPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findArrivingOrders(String ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderPO> findCurrentOrders(String ins_id)
			throws RemoteException {
		// TODO 自动生成的方法存根
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

	/**
	 * 保存寄件人信息
	 * @param info
	 * @return
	 */
	public int saveSenderinfo(PeopleInfo info) {
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
	public int saveCargoInfo(CargoInfo info) {
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
			sql.addConstraint(add_city_f, address.getCity_id());
			sql.addConstraint(add_province_f, address.getProvince_id());
			sql.addConstraint(add_district_f, address.getDistrict_id());
			ResultSet re = NetModule.excutor.excuteQuery(sql.createSQL());
			if (re.next())
				return re.getInt(add_id_f);
			// 若不存在，这先添加对应id
			addressInsert.clear();
			addressInsert.add(add_city_f, address.getCity_id());
			addressInsert.add(add_district_f, address.getDistrict_id());
			addressInsert.add(add_province_f, address.getProvince_id());
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
