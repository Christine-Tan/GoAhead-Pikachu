package po;

import java.io.Serializable;
import java.util.List;

public class ArrivedOrderPO implements Serializable {
	private List<ExpressOrderPO> orders;
	private String time;
	private String id;

	public final List<ExpressOrderPO> getOrders() {
		return orders;
	}

	public final void setOrders(List<ExpressOrderPO> orders) {
		this.orders = orders;
	}

	public final String getTime() {
		return time;
	}

	public final void setTime(String time) {
		this.time = time;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}
	
	
}
