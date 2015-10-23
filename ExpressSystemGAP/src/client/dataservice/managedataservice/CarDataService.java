package client.dataservice.managedataservice;

import client.po.CarPO;
import client.po.ResultMessage;

public interface CarDataService {
    public ResultMessage  insert(CarPO po);
    public CarPO find(String user_id);
    public ResultMessage delete(String user_id);
    public ResultMessage update(CarPO po);
}
