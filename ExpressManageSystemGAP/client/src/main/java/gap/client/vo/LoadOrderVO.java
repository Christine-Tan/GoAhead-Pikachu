package gap.client.vo;

import java.util.List;

public class LoadOrderVO {
	//
	private String date, number, departureins_id, targetins_id, loaded_id,
			trans_id;
	private List<String> orders_id;

	public LoadOrderVO(String date, String number, String departureins_id,
			String targetins_id, String loaded_id, String trans_id,
			List<String> orders_id) {
		super();
		this.date = date;
		this.number = number;
		this.departureins_id = departureins_id;
		this.targetins_id = targetins_id;
		this.loaded_id = loaded_id;
		this.trans_id = trans_id;
		this.orders_id = orders_id;
	}

	public LoadOrderVO() {
		// TODO 自动生成的构造函数存根
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDepartureins_id() {
		return departureins_id;
	}

	public void setDepartureins_id(String departureins_id) {
		this.departureins_id = departureins_id;
	}

	public String getTargetins_id() {
		return targetins_id;
	}

	public void setTargetins_id(String targetins_id) {
		this.targetins_id = targetins_id;
	}

	public String getLoaded_id() {
		return loaded_id;
	}

	public void setLoaded_id(String loaded_id) {
		this.loaded_id = loaded_id;
	}

	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	public List<String> getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(List<String> orders_id) {
		this.orders_id = orders_id;
	}
}
