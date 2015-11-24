package gap.server.data.order;

import gap.common.po.LoadOrderPO;
import gap.server.initial.NetInitial;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LoadOrderDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
		NetInitial.initial();
	}

	@Test
	public void test() {
		try {
			LoadOrderDataServiceImpl loadorder = new LoadOrderDataServiceImpl();
			List<String> orders = new ArrayList<>();
			orders.add("0000000001");
			LoadOrderPO po = new LoadOrderPO("00100011996030100001",
					"2015-06-03", "0010001001", "0010001", "0010002",
					"0010001001", "000000001", orders);
			loadorder.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
