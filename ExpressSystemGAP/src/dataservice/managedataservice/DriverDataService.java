package dataservice.managedataservice;

import po.DriverPO;
import po.ResultMessage;

public interface DriverDataService {
	public ResultMessage add(DriverPO po);

	public DriverPO find(String ins_id);

	public ResultMessage modify(DriverPO po);

	public ResultMessage delete(String ins_id);
}
