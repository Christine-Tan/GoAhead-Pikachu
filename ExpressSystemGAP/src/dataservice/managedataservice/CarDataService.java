package dataservice.managedataservice;

import po.CarPO;
import po.ResultMessage;

public interface CarDataService {

	public ResultMessage add(CarPO po);

	public CarPO find(String car_id);

	public ResultMessage modify(CarPO po);

	public ResultMessage delete(String car_id);


}
