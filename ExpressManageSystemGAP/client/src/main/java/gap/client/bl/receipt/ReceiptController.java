package gap.client.bl.receipt;

import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.ReceiptDataController;


public class ReceiptController {

	ReceiptDataController receiptDateService = null;
	private static ReceiptController receiptController =null;
	PaymentList paymentList;
	
	public ReceiptController getInstance(){
		if(receiptController==null){
			receiptController = new ReceiptController();
		}
		return receiptController;
	}
	
	private ReceiptController(){
		receiptDateService = ControllerFactory.getReceiptDataController();
	}
	



}
