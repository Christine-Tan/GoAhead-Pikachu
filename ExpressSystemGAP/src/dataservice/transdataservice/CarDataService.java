package dataservice.transdataservice;

import java.util.List;

import po.CarPO;
import util.ResultMessage;

public interface CarDataService {

	public List<CarPO> getAll();

	public ResultMessage add(CarPO po);

	public CarPO find(String car_id);

	public ResultMessage modify(CarPO po);

	public ResultMessage delete(String car_id);

}
