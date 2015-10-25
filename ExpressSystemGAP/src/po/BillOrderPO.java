package po;

import java.io.Serializable;
import java.util.Map;

public class BillOrderPO implements Serializable {
	// 快递员id和所收运费
	private Map<String, Integer> bills;
	// 收款单id
	private String id;

	public BillOrderPO() {

	}

	public BillOrderPO(Map<String, Integer> bills, String id) {
		super();
		this.bills = bills;
		this.id = id;
	}

	public Map<String, Integer> getBills() {
		return bills;
	}

	public void setBills(Map<String, Integer> bills) {
		this.bills = bills;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
