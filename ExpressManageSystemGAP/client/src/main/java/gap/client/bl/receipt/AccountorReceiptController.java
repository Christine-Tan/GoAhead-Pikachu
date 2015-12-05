package gap.client.bl.receipt;

import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.AccountorReceiptDataController;


/**
 * 和财务人员相关的收付款单的逻辑层接口，支持的需求有：制定付款单，处理收款单、付款单，按天按营业厅查收款单。
 * @author 申彬
 *
 */
public class AccountorReceiptController {

	AccountorReceiptDataController receiptDateService = null;
	private static AccountorReceiptController receiptController =null;
	PaymentList paymentList;
	
	public AccountorReceiptController getInstance(){
		if(receiptController==null){
			receiptController = new AccountorReceiptController();
		}
		return receiptController;
	}
	
	private AccountorReceiptController(){
		receiptDateService = ControllerFactory.getReceiptDataController();
	}
	



}
