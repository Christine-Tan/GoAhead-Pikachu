package gap.client.datacontroller.transdata;

import gap.common.dataservice.transdataservice.CarDataService;
import gap.common.dataservice.transdataservice.DriverDataService;
import gap.common.po.CarPO;
import gap.common.po.DriverPO;
import gap.common.util.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public class TransDataController {
	CarDataService carData;
	DriverDataService driverData;

	public ResultMessage addCar(CarPO po) {
		try {
			return carData.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage addDriver(DriverPO po) {
		try {
			return driverData.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<CarPO> getAllCar() {
		try {
			return carData.getAll();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public List<DriverPO> getAllDriver() {
		try {
			return driverData.getAll();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public CarPO findCar(String car_id) {
		try {
			return carData.find(car_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public DriverPO findDriver(String driver_id) {
		try {
			return driverData.find(driver_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage modifyCar(CarPO po) {
		try {
			return carData.modify(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage modifyDriver(DriverPO po) {
		try {
			return driverData.modify(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage deleteCar(String car_id) {
		try {
			return carData.delete(car_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage deleteDriver(String driver_id) {
		try {
			return driverData.delete(driver_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
