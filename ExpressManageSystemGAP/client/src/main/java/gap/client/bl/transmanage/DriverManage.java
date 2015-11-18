package gap.client.bl.transmanage;

import gap.client.blservice.transmanageblservice.DriverService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.transdata.TransDataController;
import gap.client.util.Driver;
import gap.client.vo.DriverVO;
import gap.common.po.DriverPO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class DriverManage implements DriverService {
	TransDataController controller = ControllerFactory.getTransDataController();

	@Override
	public List<DriverVO> getAll() {
		// TODO 自动生成的方法存根
		List<DriverVO> drivers = new ArrayList<DriverVO>();
		for (DriverPO driverpo : controller.getAllDriver()) {
			Driver driver = new Driver(driverpo);
			drivers.add(driver.toDriverVO());
		}
		return drivers;
	}

	@Override
	public DriverVO getSingle(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modify(DriverVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage add(DriverVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

}
