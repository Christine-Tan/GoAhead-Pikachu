package gap.client.blcontroller;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

import gap.client.bl.transmanage.DriverManage;
import gap.client.blservice.transmanageblservice.DriverService;
import gap.client.util.Driver;
import gap.client.util.LocalInfo;
import gap.client.vo.DriverVO;
import gap.common.dataservice.transdataservice.CarDataService;
import gap.common.po.CarPO;
import gap.common.util.ResultMessage;

public class DriverManageController {
	public static DriverManage driverManage = new DriverManage();

	public static List<DriverVO> getAll() {
		// TODO 自动生成的方法存根
		return driverManage.getAll();
	}

	public static String nextId() throws Exception {
		List<DriverVO> drivers = driverManage.getAll();
		if (drivers.size() == 0)
			return LocalInfo.ins_id + "001";
		int num = Integer.valueOf(drivers.get(drivers.size() - 1).getId().substring(7));
		num++;
		if (num >= 1000)
			throw new Exception();
		return LocalInfo.ins_id + String.valueOf(num);
	}

	public static DriverVO getSingle(String id) {
		// TODO 自动生成的方法存根
		return driverManage.getSingle(id);
	}

	public static void modify(DriverVO vo) {
		// TODO 自动生成的方法存根
		driverManage.modify(new Driver(vo));
	}

	public static void delete(String id) {
		// TODO 自动生成的方法存根
		driverManage.delete(id);
	}

	public static void add(DriverVO vo) {
		// TODO 自动生成的方法存根
		driverManage.add(new Driver(vo));
	}

	public static ResultMessage flush() {
		// TODO 自动生成的方法存根
		return driverManage.flush();
	}

}
