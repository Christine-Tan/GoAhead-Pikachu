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
		orders.add(controller.getUnpassedArrivedOrder());
		orders.add(controller.getUnpassedBillOrder());
		orders.add(controller.getUnpassedDeliveryOrder());
		orders.add(controller.getUnpassedExpressOrder());
		orders.add(controller.getUnpassedLoadOrder());
		orders.add(controller.getUnpassedStockinOrder());
		orders.add(controller.getUnpassedStockoutOrder());
		return orders;
	}

	@Override
	public ResultMessage approve() {
		// TODO Auto-generated method stub
		controller.setPassed(orders);
		return null;
	}

}
