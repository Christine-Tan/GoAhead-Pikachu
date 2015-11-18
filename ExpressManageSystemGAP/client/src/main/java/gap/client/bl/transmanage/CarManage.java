package gap.client.bl.transmanage;

import gap.client.blservice.transmanageblservice.CarService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.transdata.TransDataController;
import gap.client.util.Car;
import gap.client.vo.CarVO;
import gap.common.po.CarPO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class CarManage implements CarService {
	TransDataController controller = ControllerFactory.getTransDataController();

	@Override
	public List<CarVO> getAll() {
		// TODO 自动生成的方法存根
		List<CarVO> cars = new ArrayList<CarVO>();
		for (CarPO carpo : controller.getAllCar()) {
			Car car = new Car(carpo);
			cars.add(car.toCarVO());
		}
		return cars;
	}

	@Override
	public CarVO getSingle(String id) {
		// TODO 自动生成的方法存根
		Car car = new Car(controller.findCar(id));
		return car.toCarVO();
	}

	@Override
	public ResultMessage modify(Car car) {
		// TODO 自动生成的方法存根
		return controller.modifyCar(car.toCarPO());
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO 自动生成的方法存根
		return controller.deleteCar(id);
	}

	@Override
	public ResultMessage add(Car car) {
		// TODO 自动生成的方法存根
		return controller.addCar(car.toCarPO());
	}

}
