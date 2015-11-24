package gap.server.data.order;

import gap.common.po.DeliveryOrderPO;
import gap.server.initial.NetInitial;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DeliveryOrderDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
		NetInitial.initial();
	}

	@Test
	public void test() {
		try {
			DeliveryOrderDataServiceImpl deliveryData = new DeliveryOrderDataServiceImpl();
			Map<String, List<String>> orders = new HashMap<String, List<String>>();
			List<String> expressorders = new ArrayList<>();
			expressorders.add("0000000001");
			expressorders.add("0000000002");
			orders.put("000000001", expressorders);
			DeliveryOrderPO po = new DeliveryOrderPO(orders, "2015-03-02",
					"00100012015030100001", "测试");
			deliveryData.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
