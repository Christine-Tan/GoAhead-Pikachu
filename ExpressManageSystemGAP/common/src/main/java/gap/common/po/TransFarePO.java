package gap.common.po;

public class TransFarePO {

	private double fare;
	private String orderID;
	private String carID;

	public TransFarePO(double fare, String orderID, String carID) {
		this.fare = fare;
		this.orderID = orderID;
		this.carID = carID;

	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
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
