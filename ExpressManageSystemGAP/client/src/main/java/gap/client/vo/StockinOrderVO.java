package gap.client.vo;

import java.util.List;

public class StockinOrderVO {
	private List<String> expressorder_ids;
	private String inDate, destination, sector, location,identifier;

	// 到达日期，目的地，分区，位置,入库单编号(20位0~9数字)


	public StockinOrderVO(List<String> expressorder_ids, String inDate,
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

	public List<String> getExpressorder_ids() {
		return expressorder_ids;
	}

	public void setExpressorder_ids(List<String> expressorder_ids) {
		this.expressorder_ids = expressorder_ids;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
