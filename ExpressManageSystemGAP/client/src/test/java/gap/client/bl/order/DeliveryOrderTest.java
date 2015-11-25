package gap.client.bl.order;

import gap.client.vo.DeliveryOrderVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DeliveryOrderTest {
	DeliveryOrder deliveryOrder;

	@Before
	public void setUp() throws Exception {
		deliveryOrder = new DeliveryOrder();
	}

	@Test
	public void testDeliveryOrder() {

	}

	@Test
	public void testCreate() {
	}

	@Test
	public void testSave() {
		Map<String, List<String>> orders = new HashMap<String, List<String>>();
		List<String> expressorders = new ArrayList<>();
		expressorders.add("0000000003");
		orders.put("000000001", expressorders);
		DeliveryOrderVO order = new DeliveryOrderVO(orders, "2015-11-25",
				"00100022015112500001", "测试");
		deliveryOrder.save(order);
	}

	@Test
	public void testFind() {
	}

}
