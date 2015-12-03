package gap.client.blservice.receiptblservice;

import gap.client.vo.BillOrderVO;
import gap.client.vo.PaymentListVO;
import gap.common.util.ResultMessage;

public interface PaymentService {

	public PaymentListVO getPaymentList();
	public ResultMessage submitPaymentList(PaymentListVO paymentListVO);
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO);	
	public BillOrderVO getBillOrder();
	public ResultMessage submitBillOrder(BillOrderVO billOrderVO);
}
