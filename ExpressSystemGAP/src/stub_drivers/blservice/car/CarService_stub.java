package stub_drivers.blservice.car;

import java.util.ArrayList;
import java.util.List;

import po.CarPO;
import stub_drivers.dataservice.cardata.CarDataService_stub;
import util.ResultMessage;
import client.blservice.transmanageblservice.CarService;
import client.vo.CarVO;

public class CarService_stub implements CarService {

	CarDataService_stub datastub;

	public CarService_stub() {
		datastub = new CarDataService_stub();
	}

	@Override
	public List<CarVO> getAll() {
		// TODO 自动生成的方法存根
		List<CarVO> re = new ArrayList<CarVO>();
		for (CarPO car : datastub.getAll())
			re.add(getVO(car));
		return re;
	}

	@Override
	public CarVO getSingle(String id) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(id));
	}

	@Override
	public ResultMessage modify(CarVO vo) {
		return datastub.modify(getPO(vo));

	}

	@Override
	public ResultMessage delete(String id) {
		return datastub.delete(id);

	}

	@Override
	public ResultMessage add(CarVO vo) {
		return datastub.add(getPO(vo));

	}

	private CarVO getVO(CarPO po) {
		return new CarVO();
	}

	private CarPO getPO(CarVO vo) {
		return new CarPO();
	}
}
