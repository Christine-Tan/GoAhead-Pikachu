package client.blservice.strategyblservice;

import java.util.List;

import util.ResultMessage;
import client.vo.SalaryVO;

public interface SalaryService {
	public List<SalaryVO> getAll();

	public ResultMessage modifySalary(SalaryVO vo);

	public SalaryVO getSalary(String type);
}
