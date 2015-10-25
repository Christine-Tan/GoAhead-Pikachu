package dataservice.transdataservice;

import java.util.List;

import po.DriverPO;
import util.ResultMessage;

public interface DriverDataService {
	public List<DriverPO> getAll();

	public ResultMessage add(DriverPO po);

	public DriverPO find(String ins_id);

	public ResultMessage modify(DriverPO po);

	public ResultMessage delete(String ins_id);
}
