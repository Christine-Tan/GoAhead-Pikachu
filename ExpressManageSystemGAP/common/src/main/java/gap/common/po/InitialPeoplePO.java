package gap.common.po;

public class InitialPeoplePO {
	private String cityName;
	private int businessHallNum;
	private int centerNum;
	private int courierNum;
	private int businessClerkNum;
	private int centerClerkNum;
	private int stockmanNum;
	
	

	/**
	 * businessHall,center,courier,businessClerk,centerClerk,stockMan
	 * @param cityName
	 * @param numbers
	 */
	public InitialPeoplePO(String cityName,int[] numbers){
		this.setCityName(cityName);
		
		setBusinessHallNum(numbers[0]);
		setCenterNum(numbers[1]);
		setCourierNum(numbers[2]);
		setBusinessClerkNum(numbers[3]);
		setStockmanNum(numbers[4]);
		
	}



	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public int getBusinessHallNum() {
		return businessHallNum;
	}



	public void setBusinessHallNum(int businessHallNum) {
		this.businessHallNum = businessHallNum;
	}



	public int getCenterNum() {
		return centerNum;
	}



	public void setCenterNum(int centerNum) {
		this.centerNum = centerNum;
	}



	public int getCourierNum() {
		return courierNum;
	}



	public void setCourierNum(int courierNum) {
		this.courierNum = courierNum;
	}



	public int getBusinessClerkNum() {
		return businessClerkNum;
	}



	public void setBusinessClerkNum(int businessClerkNum) {
		this.businessClerkNum = businessClerkNum;
	}



	public int getCenterClerkNum() {
		return centerClerkNum;
	}



	public void setCenterClerkNum(int centerClerkNum) {
		this.centerClerkNum = centerClerkNum;
	}



	public int getStockmanNum() {
		return stockmanNum;
	}



	public void setStockmanNum(int stockmanNum) {
		this.stockmanNum = stockmanNum;
	}
	
}
