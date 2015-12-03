package gap.server.data.receiptdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import gap.common.dataservice.receiptdataservice.ReceiptdataService;
import gap.common.po.BillPO;
import gap.common.po.PaymentListPO;
import gap.common.po.ReceiptPO;
import gap.common.util.ResultMessage;

public class ReceiptDataServiceImpl extends UnicastRemoteObject implements ReceiptdataService{
	
	private static ReceiptdataService receiptdataService;
	PaymentSubmitter paymentSubmitter = new PaymentSubmitter();
	
	
	
	//private String 
	
	
	private ReceiptDataServiceImpl() throws RemoteException {
		super();
	}
	
	public static ReceiptdataService getInstance(){
		if(receiptdataService==null){
			try {
				receiptdataService = new ReceiptDataServiceImpl();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return receiptdataService;
	}

	@Override
	public boolean submitPayment(PaymentListPO paymentListPO) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result = paymentSubmitter.submit(paymentListPO);

		if(result==ResultMessage.SUCCEED){
			return true;
		}else{
			return false;
		}
		
	}
	
	public ArrayList<PaymentListPO> getNotPassedPayment(){
		
		return null;
	}

	@Override
	public boolean setLocked(String departmentID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReceiptPO> getReceipt(Date begin, Date end) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addBill(BillPO billPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
