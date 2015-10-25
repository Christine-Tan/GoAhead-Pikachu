package po;

import java.io.Serializable;
import java.util.Map;

public class BillOrderPO implements Serializable {
	// 快递员id和所收运费
	private Map<String, Integer> bills;
	// 收款单id
	private String id;

	public final Map<String, Integer> getBills() {
		return bills;
	}

	public final void setBills(Map<String, Integer> bills) {
		this.bills = bills;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

}
