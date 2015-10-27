package gap.common.dataservice.transdataservice;

import gap.common.po.CarPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface CarDataService {

	public List<CarPO> getAll();

	public ResultMessage add(CarPO po);

	public CarPO find(String car_id);

	public ResultMessage modify(CarPO po);

	public ResultMessage delete(String car_id);

}
