package gap.common.dataservice.receiptdataservice;

import gap.common.po.BillPO;
import gap.common.po.PaymentListPO;
import gap.common.po.ReceiptPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface ReceiptdataService extends Remote {

	public boolean submitPayment(PaymentListPO paymentListPO)
			throws RemoteException;

//	public boolean get

	public boolean setLocked(String departmentID) throws RemoteException;

	public List<ReceiptPO> getReceipt(Date begin, Date end)
			throws RemoteException;

	public Boolean addBill(BillPO billPO) throws RemoteException;

}
