package dataservice.strategydataservice;

import util.ResultMessage;
import util.UserType;
import po.SalaryPO;

public interface SalaryDataService {
	public SalaryPO find(UserType type);
    public ResultMessage add(SalaryPO po);
	public ResultMessage modify(SalaryPO po);
}
