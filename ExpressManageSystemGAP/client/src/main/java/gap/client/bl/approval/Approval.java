package gap.client.bl.approval;

import gap.client.blservice.approvalblservice.ApprovalService;
import gap.client.datacontroller.ApprovalDataController;
import gap.client.datacontroller.ControllerFactory;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class Approval implements ApprovalService {
	ApprovalDataController controller;
	List<Object> orders;

	public Approval() {
		controller = ControllerFactory.getApprovalDataController();
	}

	@Override
	public List<Object> getUnpassedOrder() {
		// TODO Auto-generated method stub
		orders = new ArrayList<Object>();
		orders.addAll(controller.getUnpassedArrivedOrder());
		orders.addAll(controller.getUnpassedBillOrder());
		orders.addAll(controller.getUnpassedDeliveryOrder());
		orders.addAll(controller.getUnpassedExpressOrder());
		orders.addAll(controller.getUnpassedLoadOrder());
		orders.addAll(controller.getUnpassedStockinOrder());
		orders.addAll(controller.getUnpassedStockoutOrder());
		orders.addAll(controller.getUnpassedPaymentListOrder());
		return orders;
	}

	@Override
	public ResultMessage approve(List<Object> orders) {
		// TODO Auto-generated method stub
		controller.setPassed(orders);
		return null;
	}

}
