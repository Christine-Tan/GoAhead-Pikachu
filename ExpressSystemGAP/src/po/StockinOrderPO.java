package po;

import java.io.Serializable;
import java.util.List;

public class StockinOrderPO implements Serializable {
	private List<String> expressorder_ids;
	private String inDate, destination, sector, location;

	// 到达日期，目的地，分区，位置

	public StockinOrderPO() {
		// TODO 自动生成的构造函数存根
	}

	public StockinOrderPO(List<String> expressorder_ids, String inDate,
			String destination, String sector, String location) {
		super();
		this.expressorder_ids = expressorder_ids;
		this.inDate = inDate;
		this.destination = destination;
		this.sector = sector;
		this.location = location;
	}

	public void deleteExpressorder_id(String expressorder_id) {
		int a = this.expressorder_ids.indexOf(expressorder_id);
		this.expressorder_ids.remove(a);
	}

	public void addExpressorder_id(String expressorder_id) {
		this.expressorder_ids.add(expressorder_id);
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String date) {
		this.inDate = date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
