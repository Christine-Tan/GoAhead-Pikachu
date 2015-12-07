package gap.client.bl.order;

import gap.client.bl.receipt.BillOrder;
import gap.client.vo.BillVO;
import gap.common.po.BillOrderPO;
import gap.common.po.BillPO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BillOrderTest {
	BillOrder billorder;

	@Before
	public void setUp() throws Exception {
		billorder = new BillOrder();
	}

	@Test
	public void testGetPreviewBills() {
		List<String> ids = new ArrayList<String>();
		ids.add("000000005");
		ids.add("000000006");
		List<BillVO> bills = billorder.getPreviewBills("2015-11-23");
		for (BillVO bill : bills) {
			System.out.println(bill.id + "," + bill.money);
		}
	}

	@Test
	public void testSave() {
		BillPO po1 = new BillPO(30.5, "000000005");
		BillPO po2 = new BillPO(25.5, "000000006");
		List<BillPO> bills = new ArrayList<>();
		bills.add(po1);
		bills.add(po2);
		BillOrderPO po = new BillOrderPO(bills, "00100012015112600002",
				Date.valueOf("2015-11-24"));
		// billorder.save(po);
	}

}
