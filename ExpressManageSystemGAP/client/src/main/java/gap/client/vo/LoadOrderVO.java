package gap.client.vo;

import gap.common.po.LoadOrderPO;

import java.util.List;

public class LoadOrderVO {
	public String order_id, date, car_id, departureins_id, targetins_id,
			driver_id, guard_id, comment;
	public List<String> orders;

	public LoadOrderVO(String order_id, String date, String car_number,
			String departureins_id, String targetins_id, String driver_id,
			String guard_id, List<String> orders) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.car_id = car_number;
		this.departureins_id = departureins_id;
		this.targetins_id = targetins_id;
		this.driver_id = driver_id;
		this.guard_id = guard_id;
		this.orders = orders;
	}

	public LoadOrderVO() {
		// TODO 自动生成的构造函数存根
	}

	public LoadOrderVO(LoadOrderPO po) {
		this.order_id = po.getOrder_id();
		this.date = po.getDate();
		this.car_id = po.getCar_number();
		this.departureins_id = po.getDepartureins_id();
		this.targetins_id = po.getTargetins_id();
		this.driver_id = po.getDriver_id();
		this.guard_id = po.getGuard_id();
		this.orders = po.getOrders();
		this.comment = po.getComment();
	}

	public LoadOrderPO toPO() {
		LoadOrderPO po = new LoadOrderPO(order_id, date, car_id,
				departureins_id, targetins_id, driver_id, guard_id, orders,
				comment);
		return po;
	}

}