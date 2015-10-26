package stub_drivers.blservice.receipte;

import client.blservice.receiptblservice.ReceiptService;
import client.vo.BillOrderVO;
import client.vo.PaymentListVO;
import util.ResultMessage;

public class Receipt_stub implements ReceiptService {

	@Override
	public PaymentListVO getPaymentList() {
		// TODO Auto-generated method stub
		return new PaymentListVO();
	}

	@Override
	public ResultMessage submitPaymentList() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

	@Override
	public BillOrderVO getBillOrder() {
		// TODO Auto-generated method stub
		return new BillOrderVO();
	}

	@Override
	public ResultMessage submitBillOrder() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

}
