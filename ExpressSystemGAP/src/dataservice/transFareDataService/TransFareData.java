package dataservice.transFareDataService;

import java.util.List;

import po.TransFarePO;

public interface TransFareData {

	public List<TransFarePO> getTransFare();
	public boolean deleteTransFare(List<TransFarePO> transFareList);
	public boolean addTransFare(TransFarePO po);

	
	
}
