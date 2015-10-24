package dataservice.strategydataservice;


import po.ResultMessage;
import po.SalaryPO;

public interface SalaryDataService {
    public SalaryPO find(String salary_id);
    public ResultMessage modify(SalaryPO po);
}
