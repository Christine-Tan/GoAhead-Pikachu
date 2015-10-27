package gap.common.dataservice.strategydataservice;

import gap.common.po.DistancePO;
import gap.common.util.ResultMessage;

public interface DistanceDataService {
	public DistancePO find(String startCity, String endCity);

	public ResultMessage add(DistancePO po);

	public ResultMessage modify(DistancePO po);
}
