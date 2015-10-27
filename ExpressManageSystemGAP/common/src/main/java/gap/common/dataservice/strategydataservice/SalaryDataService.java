package gap.common.dataservice.strategydataservice;

import gap.common.po.SalaryPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

public interface SalaryDataService {
	public SalaryPO find(UserType type);

	public ResultMessage add(SalaryPO po);

	public ResultMessage modify(SalaryPO po);
}
