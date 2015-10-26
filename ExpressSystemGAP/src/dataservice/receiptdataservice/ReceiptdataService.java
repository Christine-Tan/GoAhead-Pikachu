package dataservice.receiptdataservice;

import java.util.List;
import java.util.Date;

import po.BillPO;
import po.PaymentListPO;
import po.ReceiptPO;

public interface ReceiptdataService {

	public boolean submitPayment(PaymentListPO paymentListPO);
	public PaymentListPO getApprovedPayment(String departmentID);
	public boolean setLocked(String departmentID);
	public List<ReceiptPO> getReceipt(Date begin,Date end);
	public Boolean addBill(BillPO billPO);
	
}
