package gap.client.bl.order;

import gap.client.vo.ArrivedOrderVO;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ArrivedOrderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ArrivedOrder arrivedOrder = new ArrivedOrder();
		Map<String, String> orders = new HashMap<>();
		orders.put("0000000003", "完好");
		ArrivedOrderVO vo = new ArrivedOrderVO(orders, "2015-11-25",
				"00100012015112500001", "0010002", "0010001", "测试");
		arrivedOrder.save(vo);
	}

}
