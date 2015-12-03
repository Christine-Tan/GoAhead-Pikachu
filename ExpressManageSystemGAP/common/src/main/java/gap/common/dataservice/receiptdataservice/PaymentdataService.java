package gap.common.dataservice.receiptdataservice;

import gap.common.po.BillPO;
import gap.common.po.PaymentListPO;
import gap.common.po.ReceiptPO;
import gap.common.util.OrderState;
import gap.common.util.ResultMessage;
import gap.server.data.receiptdata.PaymentListTable;
import gap.server.data.util.SQLBuilder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface PaymentdataService extends Remote {

	public ResultMessage submitPayment(PaymentListPO paymentListPO) throws RemoteException;
	
	public ArrayList<PaymentListPO> getNotPassedPayment() throws RemoteException;


	public ArrayList<PaymentListPO> getPassedPayment(Calendar begin, Calendar end) throws RemoteException;
	
	public OrderState isPaymentPassed(String paymentID) throws RemoteException;
	
	public ResultMessage setPassed(String paymentID) throws RemoteException;

}
