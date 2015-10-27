package gap.common.po;

import java.util.ArrayList;
import java.util.Date;

public class PaymentListPO {
	public ArrayList<PaymentPO> paymentList;
	private Date payDate;

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}
