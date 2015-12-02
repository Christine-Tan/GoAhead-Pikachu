package gap.client.blcontroller;

import java.rmi.RemoteException;
import java.util.List;

import gap.client.bl.transmanage.DriverManage;
import gap.client.blservice.transmanageblservice.DriverService;
import gap.client.util.Driver;
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

	public static DriverVO getSingle(String id) {
		// TODO 自动生成的方法存根
		return driverManage.getSingle(id);
	}

	public static void modify(Driver vo) {
		// TODO 自动生成的方法存根
		driverManage.modify(vo);
	}

	public static void delete(String id) {
		// TODO 自动生成的方法存根
		driverManage.delete(id);
	}

	public static void add(Driver vo) {
		// TODO 自动生成的方法存根
		driverManage.add(vo);
	}

	public static ResultMessage flush() {
		// TODO 自动生成的方法存根
		return driverManage.flush();
	}

}
