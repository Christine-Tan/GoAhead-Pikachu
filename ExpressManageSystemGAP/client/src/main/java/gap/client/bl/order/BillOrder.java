package gap.client.bl.order;

import gap.client.blservice.orderblservice.BillOrderService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.orderdata.BillOrderDateController;
import gap.client.util.LocalInfo;
import gap.common.po.BillOrderPO;
import gap.common.po.BillPO;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BillOrder implements BillOrderService {
	BillOrderDateController billorderdataController;

	public BillOrder() {
		billorderdataController = ControllerFactory
				.getBillOrderDateController();
	}

	@Override
	public List<BillPO> getPreviewBills(List<String> delivery_ids, String date) {
		// TODO 自动生成的方法存根
		List<BillPO> bills = new ArrayList<>();
		for (String id : delivery_ids) {
			BillPO po = new BillPO(billorderdataController.getDeliveryMoney(
					date, id), id);
			bills.add(po);
		}
		return bills;
	}

	@Override
	public ResultMessage save(BillOrderPO billorder) {
		// TODO 自动生成的方法存根
		return billorderdataController.add(billorder);
	}

	@Override
	public List<UserPO> getDelivery() {
		// TODO 自动生成的方法存根
		return billorderdataController.getDelivery(LocalInfo.ins_id);
	}
}
