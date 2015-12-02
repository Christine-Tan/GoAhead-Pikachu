package gap.client.datacontroller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Provider.Service;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.receiptdataservice.ReceiptdataService;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.dataservice.transFareDataService.TransFareDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;

public class ReceiptDataController {
	AccountDataService accountDataService;
	ReceiptdataService receiptdataService;
	UserDataService userDataService;
	TransFareDataService transFareDataService;
	RentDataService rentDataService;
	SalaryDataService salaryDataService;
	
	protected ReceiptDataController(){
		
			try {
				accountDataService = (AccountDataService)Naming
						.lookup(RMIConfig.url+ServiceName.ACCOUNT_DATA_SERVICE);
				
				receiptdataService =(ReceiptdataService)Naming
						.lookup(RMIConfig.url+ServiceName.RECEIPT_DATA_SERVICE);
			
				userDataService = (UserDataService)Naming
						.lookup(RMIConfig.url+ServiceName.USER_DATA_SERVICE);
				
				transFareDataService = (TransFareDataService)Naming
						.lookup(RMIConfig.url+ServiceName.TRANSFARE_DATA_SERVICE);
			
				rentDataService = (RentDataService)Naming
						.lookup(RMIConfig.url+ServiceName.RENT_DATA_SERVICE);
			
				salaryDataService = (SalaryDataService)Naming
						.lookup(RMIConfig.url+ServiceName.SALARY_DATA_SERVICE);
			
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	
	
}
