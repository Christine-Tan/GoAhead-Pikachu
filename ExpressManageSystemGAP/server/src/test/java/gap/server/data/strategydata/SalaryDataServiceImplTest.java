package gap.server.data.strategydata;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.po.SalaryPO;

public class SalaryDataServiceImplTest {
   @Before
	@Test
	public void test() throws RemoteException {
	   SalaryDataService salarydata = new SalaryDataServiceImpl();
	   SalaryPO po1=new SalaryPO();
	}

}
