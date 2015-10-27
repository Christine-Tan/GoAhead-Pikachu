package gap.stub_driver.dataservice.expressorder;

import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ExpressType;
import gap.common.util.ResultMessage;

import java.util.List;

public class ExpressOrderDataService_driver {
	public void driver(ExpressOrderDataService expressOrder) {
		ExpressOrderPO order1 = new ExpressOrderPO("yyf", "nju", "software",
				"15520065137", "txy", "nju", "software", "110",
				ExpressType.STANDARD, null, false, "0000000001", "0011001",
				null, null, null, null, null, null);
		ExpressOrderPO order2 = new ExpressOrderPO("shenbin", "nju",
				"software", "119", "plw", "nju", "software", "120",
				ExpressType.EXPRESS, null, false, "0000000002", null,
				"0010001", null, null, null, null, null);
		// test add
		if (expressOrder.add(order1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (expressOrder.add(order2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (expressOrder.add(order1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,order exited");
		}
		// test find
		ExpressOrderPO get = expressOrder.find("0000000001");
		if (get != null)
			System.out.println("find:id=" + get.getOrder_id() + ",sender_name="
					+ get.getSender_name() + ",receiver_name="
					+ get.getReceiver_name());
		get = expressOrder.find("0000000003");
		if (get == null)
			System.out.println("find failed,not found");
		// test modify
		order1.setReceived(true);
		if (expressOrder.modify(order1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		// test findArrivingOrders
		List<ExpressOrderPO> listGet = expressOrder
				.findArrivingOrders("0010001");
		if (!listGet.isEmpty()) {
			System.out.println("find succeed:");
			for (ExpressOrderPO po : listGet) {
				System.out.println("id=" + po.getOrder_id() + ",sender_name="
						+ po.getSender_name() + ",receiver_name="
						+ po.getReceiver_name());
			}
		}
		// test findCurrentOrders
		listGet = expressOrder.findCurrentOrders("0011001");
		if (!listGet.isEmpty()) {
			System.out.println("find succeed:");
			for (ExpressOrderPO po : listGet) {
				System.out.println("id=" + po.getOrder_id() + ",sender_name="
						+ po.getSender_name() + ",receiver_name="
						+ po.getReceiver_name());
			}
		}
	}

	public static void main(String[] args) {
		ExpressOrderDataService expressOrder = new ExpressOrderDataService_stub();
		ExpressOrderDataService_driver driver = new ExpressOrderDataService_driver();
		driver.driver(expressOrder);

	}
}
