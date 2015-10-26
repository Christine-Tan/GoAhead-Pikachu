package dataservice.receoptdataservice;

import java.awt.List;

public interface ReceiptdataService {

	public boolean submitPayment(PaymentListPO paymentListPO);
	public PaymentListPO getApprovedPayment(String departmentID);
	public boolean setLocked(String departmentID);
	public List<ReceiptPO> getReceipt(Date begin,Date end);
	public Boolean addBill(BillPO billPO);
	
}
