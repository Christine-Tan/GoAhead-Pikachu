package gap.client.bl.order;

import gap.client.vo.LoadOrderVO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LoadOrderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LoadOrder loadOrder = new LoadOrder();
		List<String> list = new ArrayList<>();
		list.add("0000000003");
		LoadOrderVO vo = new LoadOrderVO("00100011996030100002", "2015-02-28",
				"88888", "0010001", "0010002", "0010001001", "000000001", list);
		loadOrder.save(vo);
	}

}
