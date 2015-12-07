package gap.client.datacontroller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.receiptdataservice.BillOrderDataService;
import gap.common.dataservice.receiptdataservice.PaymentdataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.BillOrderPO;
import gap.common.po.Cost_profitPO;
import gap.common.po.PaymentListPO;
import static gap.client.datacontroller.NetModule.accountDataService;
import static gap.client.datacontroller.NetModule.paymentdataService;
import static gap.client.datacontroller.NetModule.billorderdataservice;
/**
 * 财务人员和总经理的查看成本收益表和经营状况表的dataService
 * @author 申彬
 *
 */
public class TableDataController {
	
	protected TableDataController(){
	
	}
	
	//Account Data Interface
	public ArrayList<Cost_profitPO> getCost_Profit(){
		try {
			return accountDataService.getCost_Profit();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//Payment Data Interface
	public ArrayList<PaymentListPO> getPassedPayment(Calendar begin, Calendar end){
		try {
			return paymentdataService.getPassedPayment(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Bill order data Interface
	public List<BillOrderPO> getPassedBill(Calendar start,Calendar end){
		try {
			return billorderdataservice.getPassedOrder(start, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
