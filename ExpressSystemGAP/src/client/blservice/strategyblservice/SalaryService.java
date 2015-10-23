package client.blservice.strategyblservice;

import client.vo.SalaryVO;

public interface SalaryService {
	public void modifySalary(SalaryVO vo);

	public SalaryVO getSalary();
}
