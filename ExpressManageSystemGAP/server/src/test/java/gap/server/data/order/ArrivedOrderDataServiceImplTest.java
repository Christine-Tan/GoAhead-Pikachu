package gap.server.data.order;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.ExpressOrderPO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArrivedOrderDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			ArrivedOrderDataService arrivedOrderDataService = (ArrivedOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.ARRIVEDORDER_DATA_SERVICE);
			ExpressOrderPO po1 = new ExpressOrderPO(), po2 = new ExpressOrderPO();
			po1.setOrder_id("0000000001");
			po2.setOrder_id("0000000002");
			List<ExpressOrderPO> orders = new ArrayList<ExpressOrderPO>();
			orders.add(po1);
			orders.add(po2);
			ArrivedOrderPO arrivedPo = new ArrivedOrderPO(orders, "19960301",
					"00100011996030100001");
			arrivedOrderDataService.add(arrivedPo);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
