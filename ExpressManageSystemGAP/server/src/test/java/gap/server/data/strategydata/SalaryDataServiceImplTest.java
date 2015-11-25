package gap.server.data.strategydata;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.po.SalaryPO;
import gap.common.util.UserType;

public class SalaryDataServiceImplTest {
   @Before
	@Test
	public void test() throws RemoteException {
	   SalaryDataService salarydata = new SalaryDataServiceImpl();
	   SalaryPO po1=new SalaryPO(UserType.ADMINISTRATOR,2500);
	   SalaryPO po2=new SalaryPO(UserType.BUSSINESSCLERK,3000);
	   SalaryPO po3=new SalaryPO(UserType.CENTERCLERK,3000);
	   SalaryPO po4=new SalaryPO(UserType.DELIVERY,0.02);
	   SalaryPO po5=new SalaryPO(UserType.INVENTORY,2000);
	   SalaryPO po6=new SalaryPO(UserType.ACCOUNTER,4000);
	   System.out.println(salarydata.add(po1).getMessage());
	   System.out.println(salarydata.add(po2).getMessage());
	   System.out.println(salarydata.add(po3).getMessage());
	   System.out.println(salarydata.add(po4).getMessage());
	   System.out.println(salarydata.add(po5).getMessage());
	   System.out.println(salarydata.add(po6).getMessage());

	   SalaryPO po7=new SalaryPO(UserType.ACCOUNTER,3500);
	   System.out.println(salarydata.modify(po7).getMessage());
	   System.out.println(salarydata.find(UserType.ACCOUNTER).getSalary());
	   System.out.println("GET ALL!");
	   for(SalaryPO get:salarydata.getAll()){
		     System.out.println(get.getType().toString()+get.getSalary());
	   }
	}

}
