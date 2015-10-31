package gap.server.data.transdata;

import gap.common.dataservice.transdataservice.CarDataService;

import gap.common.po.CarPO;
import gap.common.util.ResultMessage;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDataServiceImpl extends UnicastRemoteObject implements
		CarDataService {

	public CarDataServiceImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public List<CarPO> getAll() throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<CarPO> cars = new ArrayList<CarPO>();
			ResultSet re = NetModule.excutor.excuteQuery("SELECT * FROM car");
			while (re.next()) {
				String id = re.getString("car_id"), car_num = re
						.getString("car_num"), ins_id = re
						.getString("institution_id");
				int server_time = re.getInt("server_time");
				CarPO po = new CarPO(id, car_num, ins_id, server_time);
				cars.add(po);
			}
			return cars;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(CarPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String car_id = "'" + po.getCar_id() + "'", car_num = "'"
				+ po.getCar_num() + "'", ins_id = "'" + po.getIns_id() + "'";
		int server_time = po.getServe_time();
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM car WHERE car_id=" + car_id
							+ ";");
			if (re.next()) {
				System.out.println("车辆存在 车牌号为:" + re.getString("car_num"));
				return ResultMessage.EXITED;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		try {
			String sql = "INSERT INTO car (car_id,car_num,institution_id,server_time) VALUES ("
					+ car_id
					+ ","
					+ car_num
					+ ","
					+ ins_id
					+ ","
					+ server_time
					+ ");";
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return ResultMessage.SUCCEED;
	}

	public CarPO find(String car_id) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM car WHERE car_id=" + car_id
							+ ";");
			re.next();
			String id = re.getString("car_id"), car_num = re
					.getString("car_num"), ins_id = re
					.getString("institution_id");
			int server_time = re.getInt("server_time");
			CarPO po = new CarPO(id, car_num, ins_id, server_time);
			return po;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage modify(CarPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String car_id = "'" + po.getCar_id() + "'", car_num = "'"
				+ po.getCar_num() + "'", ins_id = "'" + po.getIns_id() + "'";
		int server_time = po.getServe_time();
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM car WHERE car_id=" + car_id
							+ ";");
			if (!re.next()) {
				return ResultMessage.NOTFOUND;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		try {
			String sql = "UPDATE car set car_num=" + car_num
					+ ",institution_id=" + ins_id + ",server_time="
					+ server_time + " WHERE car_id=" + car_id + ";";
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return ResultMessage.SUCCEED;
	}

	public ResultMessage delete(String car_id) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			NetModule.excutor.excute("DELETE FROM user WHERE id=" + car_id
					+ ";");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return ResultMessage.SUCCEED;
	}

}
