package po;

import java.io.Serializable;
import java.util.List;

public class StockoutOrderPO implements Serializable {
	private List<String> expressorder_ids;
	private String outDate, destination, transportation, identifier;

	// 出库日期，目的地，货运方式，中转单编号或装车单编号

	public StockoutOrderPO() {

	}

	public StockoutOrderPO(List<String> expressorder_ids, String outDate,
			String destination, String transportation, String identifier) {
		super();
		this.expressorder_ids = expressorder_ids;
		this.outDate = outDate;
		this.destination = destination;
		this.transportation = transportation;
		this.identifier = identifier;
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
