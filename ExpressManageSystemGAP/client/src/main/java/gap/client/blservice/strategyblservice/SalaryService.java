package gap.client.blservice.strategyblservice;

import gap.client.vo.SalaryVO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

import java.util.List;

public interface SalaryService {
	public List<SalaryVO> getAll();

	public ResultMessage modifySalary(SalaryVO vo);

	public SalaryVO getSalary(UserType type);
	
    public ResultMessage addSalary(SalaryVO vo);
}
