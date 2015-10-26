package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class BillOrderPO implements Serializable {
	// 快递员id和所收运费
	private ArrayList<BillPO> bills;
	// 收款单id
	private String id;

	public BillOrderPO() {

	}

	public BillOrderPO(ArrayList<BillPO> bills, String id) {
		super();
		this.bills = bills;
		this.id = id;
	}

	public ArrayList<BillPO> getBills() {
		return bills;
	}

	public void setBills(ArrayList<BillPO> bills) {
		this.bills = bills;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
