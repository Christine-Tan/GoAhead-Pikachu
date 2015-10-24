package dataservice.strategydataservice;

import po.DistancePO;
import po.ResultMessage;

public interface DistanceDataService {
    public DistancePO find(String city_id);
    public ResultMessage add(DistancePO po);
    public ResultMessage modify(DistancePO po);
}
