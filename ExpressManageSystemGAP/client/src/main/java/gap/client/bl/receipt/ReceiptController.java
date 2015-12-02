package gap.client.bl.receipt;

import javax.naming.ldap.ControlFactory;

import gap.client.blservice.receiptblservice.ReceiptService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.ReceiptDataController;
import gap.client.vo.BillOrderVO;
import gap.client.vo.PaymentListVO;
import gap.common.util.ResultMessage;

public class ReceiptController implements ReceiptService{

	ReceiptDataController receiptDateService = null;
	private static ReceiptService receiptController =null;
	PaymentList paymentList;
	
	public ReceiptService getInstance(){
		if(receiptController==null){
			receiptController = new ReceiptController();
		}
		return receiptController;
	}
	
	private ReceiptController(){
		receiptDateService = ControllerFactory.getReceiptDataController();
	}
	
	
	@Override
	public PaymentListVO getPaymentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submitPaymentList(PaymentListVO paymentListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillOrderVO getBillOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submitBillOrder(BillOrderVO billOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
