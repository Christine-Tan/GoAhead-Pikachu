package gap.client.bl.receipt;

import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.ReceiptDataController;
import gap.client.vo.BillOrderVO;
import gap.client.vo.PaymentListVO;
import gap.common.util.ResultMessage;

public class ReceiptController{

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
	

	public PaymentListVO getPaymentList() {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage submitPaymentList(PaymentListVO paymentListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public BillOrderVO getBillOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage submitBillOrder(BillOrderVO billOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
