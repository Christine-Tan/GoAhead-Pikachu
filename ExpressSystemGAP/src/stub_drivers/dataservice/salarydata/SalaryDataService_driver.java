package stub_drivers.dataservice.salarydata;


import dataservice.strategydataservice.SalaryDataService;
import po.SalaryPO;
import util.ResultMessage;
import util.UserType;

public class SalaryDataService_driver {
	public void driver(SalaryDataService salaryData) {
		SalaryPO salary1 = new SalaryPO(UserType.BUSSINESSCLERK, 3000);
		SalaryPO salary2 = new SalaryPO(UserType.INVENTORY, 2000);
		if (salaryData.add(salary1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (salaryData.add(salary2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (salaryData.add(salary1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		SalaryPO get = salaryData.find("Salesman");
		if (get != null)
			System.out.println("find:type=" + get.getType() + ",salary="
					+ get.getSalary());
		get = salaryData.find("GeneralManager");
		if (get == null)
			System.out.println("find failed,not found");
		salary1.setType(UserType.CENTERCLERK);
		if (salaryData.modify(salary1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
	
	public static void main(String[] args) {
		SalaryDataService salaryData = new SalaryDataService_stub();
		SalaryDataService_driver driver = new SalaryDataService_driver();
		driver.driver(salaryData);
	}
}
