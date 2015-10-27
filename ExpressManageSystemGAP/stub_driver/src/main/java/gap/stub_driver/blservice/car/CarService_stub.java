package gap.stub_driver.blservice.car;

import gap.client.blservice.transmanageblservice.CarService;
import gap.client.vo.CarVO;
import gap.common.po.CarPO;
import gap.common.util.ResultMessage;
import gap.stub_driver.dataservice.cardata.CarDataService_stub;

import java.util.ArrayList;
import java.util.List;

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
		if (po == null)
			return null;
		return new CarVO(po.getCar_id(), po.getCar_num(), po.getIns_id(),
				po.getServe_time());
	}

	private CarPO getPO(CarVO vo) {
		if (vo == null)
			return null;
		return new CarPO(vo.getCar_id(), vo.getCar_num(), vo.getIns_id(),
				vo.getServe_time());
	}
}
