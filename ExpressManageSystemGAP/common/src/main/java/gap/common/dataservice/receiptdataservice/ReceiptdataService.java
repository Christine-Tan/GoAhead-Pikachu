package gap.common.dataservice.receiptdataservice;

import gap.common.po.BillPO;
import gap.common.po.PaymentListPO;
import gap.common.po.ReceiptPO;

import java.util.Date;
import java.util.List;

public interface ReceiptdataService {

	public boolean submitPayment(PaymentListPO paymentListPO);

	public PaymentListPO getApprovedPayment(String departmentID);

	public boolean setLocked(String departmentID);

	public List<ReceiptPO> getReceipt(Date begin, Date end);

	public Boolean addBill(BillPO billPO);

}
