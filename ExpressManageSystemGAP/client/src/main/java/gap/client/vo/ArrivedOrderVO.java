package gap.client.vo;

import gap.common.po.ExpressOrderPO;

import java.util.List;



public class ArrivedOrderVO {
	// 到达单订单
	private List<ExpressOrderPO> orders;
	// 生成时间
	private String time;
	// 到达单编号
	private String id;

	public ArrivedOrderVO(List<ExpressOrderPO> orders, String time, String id) {
		super();
		this.orders = orders;
		this.time = time;
		this.id = id;
	}

	public ArrivedOrderVO() {
		// TODO 自动生成的构造函数存根
	}

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
