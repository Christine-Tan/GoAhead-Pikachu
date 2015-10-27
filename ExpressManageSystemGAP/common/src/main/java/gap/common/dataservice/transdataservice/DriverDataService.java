package gap.common.dataservice.transdataservice;

import gap.common.po.DriverPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface DriverDataService {
	public List<DriverPO> getAll();

	public ResultMessage add(DriverPO po);

	public DriverPO find(String ins_id);

	public ResultMessage modify(DriverPO po);

	public ResultMessage delete(String ins_id);
}
