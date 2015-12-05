package gap.client.blservice.receiptblservice;

import gap.client.vo.BillOrderVO;
import gap.client.vo.PayeeVO;
import gap.client.vo.PaymentListVO;
import gap.common.po.PaymentListPO;
import gap.common.util.ResultMessage;

public interface PaymentService {

	/**
	 * 获得付款单草稿
	 * @return
	 */
	public PaymentListVO getPaymentList();
	
	/**
	 * 提交制定完毕的收款单，等待总经理审批
	 * @param paymentListVO
	 * @return
	 */
	public ResultMessage submitPaymentList(PaymentListVO paymentListVO);
	
	/**
	 * 供总经理调用的接口，用来处理从数据库读出的，通过审批的付款单
	 * @param paymentListPO
	 * @return
	 */
	public ResultMessage handlePaymentList(PaymentListPO paymentListPO);
	
	/**
	 * 增加一个收款人/收款项
	 * @param payeeVO
	 * @return
	 */
	public ResultMessage addPayee(PayeeVO payeeVO);
	
	/**
	 * 删除
	 * @param payeeVO
	 * @return
	 */
	public ResultMessage deletePayee(PayeeVO payeeVO);
	
	/**
	 * 修改
	 * @param payeeVO
	 * @return
	 */
	public ResultMessage modifyPayee(PayeeVO payeeVO);
	public ResultMessage paymetnExcel(PaymentListVO paymentListVO);	
	public BillOrderVO getBillOrder();
	public ResultMessage submitBillOrder(BillOrderVO billOrderVO);
}
