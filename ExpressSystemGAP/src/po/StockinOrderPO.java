package po;

import java.io.Serializable;

public class StockinOrderPO implements Serializable{
	private String expressorder_id,inDate,destination,sector,location;

	
	
	
	public StockinOrderPO(String expressorder_id, String inDate,
			String destination, String sector, String location) {
		super();
		this.expressorder_id = expressorder_id;
		this.inDate = inDate;
		this.destination = destination;
		this.sector = sector;
		this.location = location;
	}

	public String getExpressorder_id() {
		return expressorder_id;
	}

	public void setExpressorder_id(String expressorder_id) {
		this.expressorder_id = expressorder_id;
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
