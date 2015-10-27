package gap.common.po;

public class TransFarePO {

	private int fare;
	private String orderID;
	private String carID;

	public TransFarePO(int fare, String orderID, String carID) {
		this.fare = fare;
		this.orderID = orderID;
		this.carID = carID;

	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

}
