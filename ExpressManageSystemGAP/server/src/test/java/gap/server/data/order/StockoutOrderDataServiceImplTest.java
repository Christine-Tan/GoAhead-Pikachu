package gap.server.data.order;

import static org.junit.Assert.*;
import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.netconfig.RMIConfig;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class StockoutOrderDataServiceImplTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			StockoutOrderDataService stockinorder = (StockoutOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.STOCKOUTORDER_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
