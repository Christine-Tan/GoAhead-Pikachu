package dataservice.strategydataservice;

import util.ResultMessage;
import po.SalaryPO;

public interface SalaryDataService {
	public SalaryPO find(String salary_id);
    public ResultMessage add(SalaryPO po);
	public ResultMessage modify(SalaryPO po);
}
