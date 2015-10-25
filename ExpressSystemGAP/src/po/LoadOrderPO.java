package po;

import java.io.Serializable;
import java.util.List;

public class LoadOrderPO implements Serializable {
	//
	private String date, number, departureins_id, targetins_id, loaded_id,
			trans_id;
	private List<String> orders_id;

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
