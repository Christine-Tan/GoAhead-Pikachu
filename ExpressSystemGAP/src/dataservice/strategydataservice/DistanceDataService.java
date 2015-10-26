package dataservice.strategydataservice;

import po.DistancePO;
import util.ResultMessage;


public interface DistanceDataService {
	public DistancePO find(String startCity,String endCity);

	public ResultMessage add(DistancePO po);

	public ResultMessage modify(DistancePO po);
}
