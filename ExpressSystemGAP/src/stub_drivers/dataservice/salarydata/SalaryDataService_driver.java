package stub_drivers.dataservice.salarydata;

import po.SalaryPO;
import util.ResultMessage;
import util.UserType;

public class SalaryDataService_driver {
	public static void main(String[] args) {
		SalaryDataService_stub stub = new SalaryDataService_stub();
		SalaryPO salary1 = new SalaryPO(UserType.BUSSINESSCLERK, 3000);
		SalaryPO salary2 = new SalaryPO(UserType.INVENTORY, 2000);
		if (stub.add(salary1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(salary2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(salary1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,car exited");
		}
		SalaryPO get = stub.find("Salesman");
		if (get != null)
			System.out.println("find:type=" + get.getType() + ",salary="
					+ get.getSalary());
		get = stub.find("GeneralManager");
		if (get == null)
			System.out.println("find failed,not found");
		salary1.setType(UserType.CENTERCLERK);
		if (stub.modify(salary1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
	}
}
