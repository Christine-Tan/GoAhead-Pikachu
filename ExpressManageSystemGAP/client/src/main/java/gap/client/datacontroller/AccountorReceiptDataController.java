package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.receiptdataservice.BillOrderDataService;
import gap.common.dataservice.receiptdataservice.PaymentdataService;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.dataservice.transFareDataService.TransFareDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.AccountPO;
import gap.common.po.BillOrderPO;
import gap.common.po.Cost_profitPO;
import gap.common.po.PaymentListPO;
import gap.common.po.RentPO;
import gap.common.po.SalaryPO;
import gap.common.po.TradePO;
import gap.common.po.TransFarePO;
import gap.common.po.UserPO;
import gap.common.util.OrderState;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 和财务人员相关的收付款单的data层接口，支持的需求有：制定付款单，处理收款单、付款单，按天按营业厅查收款单。
 * @author 申彬
 *
 */
public class AccountorReceiptDataController {
	AccountDataService accountDataService;
	PaymentdataService paymentdataService;
	BillOrderDataService billOrderDataService;
	ExpressOrderDataService expressOrderDataService;
	UserDataService userDataService;
	TransFareDataService transFareDataService;
	RentDataService rentDataService;
	SalaryDataService salaryDataService;
	
	
	protected AccountorReceiptDataController(){
		
			try {
				accountDataService = (AccountDataService)Naming
						.lookup(RMIConfig.url+ServiceName.ACCOUNT_DATA_SERVICE);
				
				paymentdataService =(PaymentdataService)Naming
						.lookup(RMIConfig.url+ServiceName.PAYMENT_DATA_SERVICE);
			
				userDataService = (UserDataService)Naming
						.lookup(RMIConfig.url+ServiceName.USER_DATA_SERVICE);
				
				transFareDataService = (TransFareDataService)Naming
						.lookup(RMIConfig.url+ServiceName.TRANSFARE_DATA_SERVICE);
			
				rentDataService = (RentDataService)Naming
						.lookup(RMIConfig.url+ServiceName.RENT_DATA_SERVICE);
			
				salaryDataService = (SalaryDataService)Naming
						.lookup(RMIConfig.url+ServiceName.SALARY_DATA_SERVICE);
				
				billOrderDataService = (BillOrderDataService)Naming
						.lookup(RMIConfig.url+ServiceName.BILLORDER_DATA_SERVICE);
			
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	//accountData的接口
	public boolean trade(TradePO tradePO){
		try {
			return accountDataService.trade(tradePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	public ArrayList<AccountPO> getAccountList(){
		try {
			return accountDataService.getAccountList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//PaymentData的接口
	public ResultMessage submitPayment(PaymentListPO paymentListPO){
		try {
			return paymentdataService.submitPayment(paymentListPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
	}
	public ArrayList<PaymentListPO> getPassedPayment(Calendar begin, Calendar end){
		try {
			return paymentdataService.getPassedPayment(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public OrderState isPaymentPassed(String paymentID){
		try {
			return paymentdataService.isPaymentPassed(paymentID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultMessage setPaymentPassed(String paymentID){
		try {
			return paymentdataService.setPassed(paymentID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//BillOrder的接口
	public ResultMessage setBillOrderPassed(String order_id){
		try {
			return billOrderDataService.setPassed(order_id, null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<BillOrderPO> getPassedBill(Calendar oneDay,String institutionID){
		try {
			return billOrderDataService.getPassedOrder(oneDay, institutionID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public OrderState isBillPassed(String orderID){
		try {
			return billOrderDataService.isOrderPassed(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//expressOrderData的接口
	public double getDeliveryMoney(String date, String delivery_id){
		try {
			return expressOrderDataService.getDeliveryMoney(date, delivery_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	//userdate的接口
	public List<UserPO> findUnpaidUser(Date date){
		try {
			return userDataService.findUnpaidUser(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage setUserPaid(String user_id){
		try {
			return userDataService.setPaid(user_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//transFareData
	public List<TransFarePO> getTransFare(){
		try {
			return transFareDataService.getTransFare();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteTransFare(List<TransFarePO> transFareList){
		try {
			return transFareDataService.deleteTransFare(transFareList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//rentData
	public List<RentPO> getAllRentPO(){
		try {
			return rentDataService.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultMessage setInstitePaid(String institution){
		try {
			return rentDataService.setPaid(institution);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Salary
	public List<SalaryPO> getAllSalaryPO(){
		try {
			return salaryDataService.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
