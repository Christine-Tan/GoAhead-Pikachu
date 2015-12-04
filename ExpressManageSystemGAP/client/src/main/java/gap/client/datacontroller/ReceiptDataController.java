package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.receiptdataservice.BillOrderDataService;
import gap.common.dataservice.receiptdataservice.PaymentdataService;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.dataservice.transFareDataService.TransFareDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.AccountPO;
import gap.common.po.Cost_profitPO;
import gap.common.po.PaymentListPO;
import gap.common.po.TradePO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

public class ReceiptDataController {
	AccountDataService accountDataService;
	PaymentdataService paymentdataService;
	UserDataService userDataService;
	TransFareDataService transFareDataService;
	RentDataService rentDataService;
	SalaryDataService salaryDataService;
	BillOrderDataService billOrderDataService;
	
	protected ReceiptDataController(){
		
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
	
	public boolean trade(TradePO tradePO){
		try {
			return accountDataService.trade(tradePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Cost_profitPO> getCost_Profit(){
		try {
			return accountDataService.getCost_Profit();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
	
	public ResultMessage submitPayment(PaymentListPO paymentListPO){
		return null;
	}
	public ArrayList<PaymentListPO> getPassedPayment(Calendar begin, Calendar end){
		return null;
	}
	
	
}
