package po;

import java.io.Serializable;

public class StockoutOrderPO implements Serializable{
	private String expressorder_id,outDate,destination,transportation,identifier;

	public StockoutOrderPO(String expressorder_id, String outDate,
			String destination, String transportation, String identifier) {
		super();
		this.expressorder_id = expressorder_id;
		this.outDate = outDate;
		this.destination = destination;
		this.transportation = transportation;
		this.identifier = identifier;
	}

	public String getExpressorder_id() {
		return expressorder_id;
	}

	public void setExpressorder_id(String expressorder_id) {
		this.expressorder_id = expressorder_id;
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
