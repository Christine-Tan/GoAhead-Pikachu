package gap.client.blcontroller;

import gap.client.bl.order.BillOrder;
import gap.client.vo.BillVO;
import gap.common.po.UserPO;

import java.util.List;

public class BillOrderController {
	public static BillOrder billOrder;

	public static List<BillVO> getBills(String date) {
		return billOrder.getPreviewBills(date);
	}
}
