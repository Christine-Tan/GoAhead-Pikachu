package dataservice.strategydataservice;

import po.PricePO;

import util.ResultMessage;

public interface PriceDataService {
	public PricePO find(String city_id);

	public ResultMessage add(PricePO po);

	public ResultMessage modify(PricePO po);
}
