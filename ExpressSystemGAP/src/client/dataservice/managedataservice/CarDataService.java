package client.dataservice.managedataservice;

import client.po.CarPO;
import client.po.ResultMessage;

public interface CarDataService {
<<<<<<< HEAD
    public ResultMessage  insert(CarPO po);
    public CarPO find(String user_id);
    public ResultMessage delete(String user_id);
    public ResultMessage update(CarPO po);
=======
	public ResultMessage add(CarPO po);

	public CarPO find(String car_id);

	public ResultMessage modify(CarPO po);

	public ResultMessage delete(String car_id);

>>>>>>> origin/master
}
