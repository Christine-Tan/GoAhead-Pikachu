package stub_drivers.blservice.salary;

import client.blservice.strategyblservice.SalaryService;
import client.vo.SalaryVO;
import stub_drivers.dataservice.salarydata.SalaryDataService_driver;
import stub_drivers.dataservice.salarydata.SalaryDataService_stub;
import util.ResultMessage;
import util.UserType;
import dataservice.strategydataservice.SalaryDataService;

public class SalaryService_driver {
	public void driver(SalaryService salary) {
		SalaryVO salary1 = new SalaryVO(UserType.BUSSINESSCLERK, 3000);
		SalaryVO salary2 = new SalaryVO(UserType.INVENTORY, 2000);
		if (salary.addSalary(salary1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (salary.addSalary(salary2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (salary.addSalary(salary1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		SalaryVO get = salary.getSalary(UserType.DELIVERY);
		if (get != null)
			System.out.println("find:type=" + get.getType() + ",salary="
					+ get.getSalary());
		get = salary.getSalary(UserType.MANAGER);
		if (get == null)
			System.out.println("find failed,not found");
		salary1.setType(UserType.CENTERCLERK);
		if (salary.modifySalary(salary1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
	
	public static void main(String[] args) {
		SalaryDataService salaryData = new SalaryDataService_stub();
		SalaryDataService_driver driver = new SalaryDataService_driver();
		driver.driver(salaryData);
	}
}
