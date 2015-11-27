package gap.server.data.receiptdata;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import gap.common.dataservice.receiptdataservice.ReceiptdataService;
import gap.common.po.BillPO;
import gap.common.po.PaymentListPO;
import gap.common.po.ReceiptPO;

public class ReceiptDataService implements ReceiptdataService{

	@Override
	public boolean submitPayment(PaymentListPO paymentListPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
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
