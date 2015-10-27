package gap.client.vo;

import java.util.List;

public class StockoutOrderVO {
	private List<String> expressorder_ids;
	private String outDate, destination, transportation, identifier;

	// 出库日期，目的地，货运方式，中转单编号或装车单编号


	public StockoutOrderVO(List<String> expressorder_ids, String outDate,
			String destination, String transportation, String identifier) {
		super();
		this.expressorder_ids = expressorder_ids;
		this.outDate = outDate;
		this.destination = destination;
		this.transportation = transportation;
		this.identifier = identifier;
	}
	
	public List<String> getExpressorder_ids() {
		return expressorder_ids;
	}

	

	public void setExpressorder_ids(List<String> expressorder_ids) {
		this.expressorder_ids = expressorder_ids;
	}

	public void deleteExpressorder_id(String expressorder_id) {
		int a = this.expressorder_ids.indexOf(expressorder_id);
		this.expressorder_ids.remove(a);
	}

	public void addExpressorder_id(String expressorder_id) {
		this.expressorder_ids.add(expressorder_id);
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
