package client.blservice.receiptblservice;

import client.vo.BillOrderVO;
import client.vo.PaymentListVO;
import util.ResultMessage;

public interface ReceiptService {

	public PaymentListVO getPaymentList();
	public ResultMessage submitPaymentList();
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO);	
	public BillOrderVO getBillOrder();
	public ResultMessage submitBillOrder();
}
