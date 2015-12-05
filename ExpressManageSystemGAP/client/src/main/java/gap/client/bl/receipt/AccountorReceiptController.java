package gap.client.bl.receipt;

import gap.client.datacontroller.ControllerFactory;
import gap.client.vo.BillOrderVO;
import gap.client.vo.PayeeVO;
import gap.client.vo.PaymentListVO;
import gap.common.po.BillOrderPO;
import gap.common.po.PaymentListPO;
import gap.common.util.ResultMessage;
import java.util.Calendar;
import java.util.List;
import gap.client.blservice.accountorReceiptblservice.AccountorReceiptService;
import gap.client.datacontroller.AccountorReceiptDataController;


/**
 * 和财务人员相关的收付款单的逻辑层接口，支持的需求有：制定付款单，处理收款单、付款单，按天按营业厅查收款单。
 * @author 申彬
 *
 */
public class AccountorReceiptController implements AccountorReceiptService{

	AccountorReceiptDataController receiptDateController = null;
	private static AccountorReceiptController receiptController =null;
	PaymentList paymentList;
	
	public AccountorReceiptController getInstance(){
		if(receiptController==null){
			receiptController = new AccountorReceiptController();
		}
		return receiptController;
	}
	
	private AccountorReceiptController(){
		receiptDateController = ControllerFactory.getReceiptDataController();
		paymentList = new PaymentList(receiptDateController);
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
	public ResultMessage handlePaymentList(PaymentListPO paymentListPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addPayee(PayeeVO payeeVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deletePayee(PayeeVO payeeVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyPayee(PayeeVO payeeVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BillOrderVO> getBillOrderByDateOrIns(Calendar oneDay, String insitituteID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage handleBillOrder(BillOrderPO billOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
