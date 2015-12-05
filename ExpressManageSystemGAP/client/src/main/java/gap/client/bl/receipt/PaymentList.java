package gap.client.bl.receipt;

import gap.client.datacontroller.AccountorReceiptDataController;
import gap.client.vo.PayeeVO;
import gap.client.vo.PaymentListVO;
import gap.common.po.AccountPO;
import gap.common.po.SalaryPO;
import gap.common.util.ResultMessage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 逻辑层的付款单对象，创建时会读取数据库信息
 * @author 申彬
 *
 */
public class PaymentList {
	
	ArrayList<PayeeVO> payeeList;
	AccountorReceiptDataController dataController;
	static ArrayList<AccountPO> accounts;
	
	List<SalaryPO> salaryPOs;
	
	PaymentListVO listVO;
	
	public PaymentList(AccountorReceiptDataController dataController){
		payeeList = new ArrayList<>();
		this.dataController = dataController;	
		salaryPOs=dataController.getAllSalaryPO();
		
		if(accounts!=null){
			accounts = dataController.getAccountList();
		}
	}
	
	/**
	 * 读取数据库，创建付款单草稿
	 * @return
	 */
	
	public static ArrayList<AccountPO> getAccounts(){
		return accounts;
	}
	
//	public PaymentListVO creatPaymentList(){
//		
//	}
//	
//	
//	public ResultMessage addPayee(PayeeVO payeeVO){}
//	
//	/**
//	 * 删除
//	 * @param payeeVO
//	 * @return
//	 */
//	public ResultMessage deletePayee(PayeeVO payeeVO){}
//	
//	/**
//	 * 修改
//	 * @param payeeVO
//	 * @return
//	 */
//	public ResultMessage modifyPayee(PayeeVO payeeVO){}
	
}
