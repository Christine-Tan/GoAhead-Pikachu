package gap.common.dataservice.strategydataservice;

import gap.common.po.PricePO;
import gap.common.util.ResultMessage;

public interface PriceDataService {
	public PricePO find(String city_id);

	public ResultMessage add(PricePO po);

	public ResultMessage modify(PricePO po);
}
