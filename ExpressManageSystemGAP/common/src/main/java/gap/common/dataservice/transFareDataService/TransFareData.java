package gap.common.dataservice.transFareDataService;

import gap.common.po.TransFarePO;

import java.util.List;

public interface TransFareData {

	public List<TransFarePO> getTransFare();

	public boolean deleteTransFare(List<TransFarePO> transFareList);

	public boolean addTransFare(TransFarePO po);

}
