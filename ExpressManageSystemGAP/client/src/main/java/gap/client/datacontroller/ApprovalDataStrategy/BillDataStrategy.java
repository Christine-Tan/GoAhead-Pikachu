package gap.client.datacontroller.ApprovalDataStrategy;

import gap.client.blcontroller.AccountorReceiptController;
import gap.client.blservice.accountorReceiptblservice.AccountorReceiptService;
import gap.client.datacontroller.AppDataStrategyFactory;
import gap.client.datacontroller.ControllerFactory;
import gap.common.ListInterface.Order;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.po.BillOrderPO;
import gap.common.util.ResultMessage;

public class BillDataStrategy extends AppStrategy{

	public BillDataStrategy(AppDataStrategyFactory factory) {
		super(factory);

	}

	@Override
	public ResultMessage setPassed(Order order) {
		ResultMessage rm = null;
		AccountorReceiptController accountDataService = AccountorReceiptController.getInstance();
		BillOrderPO aBillOrderPO = (BillOrderPO)order;
		rm = accountDataService.handleBillOrder(aBillOrderPO);
		return rm;
	}

}
