package stub_drivers.blservice.salary;

import java.util.ArrayList;
import java.util.List;

import po.SalaryPO;
import stub_drivers.dataservice.salarydata.SalaryDataService_stub;
import util.ResultMessage;
import util.UserType;
import client.blservice.strategyblservice.SalaryService;
import client.vo.SalaryVO;

public class SalaryService_stub implements SalaryService{
	 SalaryDataService_stub datastub;

	public SalaryService_stub() {
		datastub = new SalaryDataService_stub();
	}
	@Override
	public SalaryVO getSalary(UserType type) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(type));
	}

	@Override
	public List<SalaryVO> getAll() {
		// TODO 自动生成的方法存根
		List<SalaryVO> list = new ArrayList<SalaryVO>();
		for (SalaryPO user : datastub.getAll())
			list.add(getVO(user));
		return list;
	}

	@Override
	public ResultMessage modifySalary(SalaryVO vo) {
		// TODO 自动生成的方法存根
		return datastub.modify(getPO(vo));
	}

	private SalaryVO getVO(SalaryPO po) {
		return new SalaryVO();
	}

	private SalaryPO getPO(SalaryVO vo) {
		return new SalaryPO();
	}

	@Override
	public ResultMessage addSalary(SalaryVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
}
