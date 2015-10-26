package client.blservice.receiptblservice;

import client.blservice.receiptbl.PaymentListVO;
import client.blservice.receiptbl.ResultMessage;
import client.blservice.receiptbl.billOrderVO;
import client.blservice.receiptbl.paymentListVO;

public interface ReceiptService {

	public paymentListVO getPaymentList();
	public ResultMessage submitPaymentList();
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO);	
	public billOrderVO getBillOrder();
	public ResultMessage submitBillOrder();
}
