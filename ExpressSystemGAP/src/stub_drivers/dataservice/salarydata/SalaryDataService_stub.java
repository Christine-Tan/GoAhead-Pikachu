package stub_drivers.dataservice.salarydata;

import java.util.ArrayList;
import java.util.List;

import util.ResultMessage;
import po.InstitutionPO;
import po.SalaryPO;
import dataservice.strategydataservice.SalaryDataService;

public class SalaryDataService_stub implements SalaryDataService {
	private ArrayList<SalaryPO>  list;

	public  SalaryDataService_stub() {
		list = new ArrayList<SalaryPO>();
	}
	@Override
	public SalaryPO find(String salaryType) {
		// TODO 自动生成的方法存根
		for (SalaryPO salary : list)
			if (salaryType.equals(salary.getType()))
				return salary;
		return null;
	}

	@Override
	public ResultMessage modify(SalaryPO po) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < list.size(); i++) {
			if (po.getType().equals(list.get(i).getType()))
				list.remove(i);
				list.add(po);
				return ResultMessage.SUCCEED;
			}
		return ResultMessage.NOTFOUND;
	}
	
	public List<SalaryPO> getAll() {
		// TODO 自动生成的方法存根
		return list;
	}

}
