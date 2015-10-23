package client.dataservice.managedataservice;

import client.po.DriverPO;
import client.po.ResultMessage;

public interface DriverDataService {
	public ResultMessage add(DriverPO po);

	public DriverPO find(String ins_id);

	public ResultMessage modify(DriverPO po);

	public ResultMessage delete(String ins_id);
}
