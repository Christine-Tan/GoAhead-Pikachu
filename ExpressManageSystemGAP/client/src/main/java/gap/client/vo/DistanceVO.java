package gap.client.vo;

public class DistanceVO {
     
	 String startCity;
     String endCity;
     double distance;
     
	 public DistanceVO(){
     }
        
     public DistanceVO(String startCity,String endCity, double distance){
              this.startCity=startCity;
              this.endCity=endCity;
              this.distance=distance;
     }

	/**
	 * @return startCity
	 */
	public String getStartCity() {
		return startCity;
	}

	/**
	 * @param startCity 要设置的 startCity
	 */
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	/**
	 * @return endCity
	 */
	public String getEndCity() {
		return endCity;
	}

	/**
	 * @param endCity 要设置的 endCity
	 */
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	/**
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance 要设置的 distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
     
     
}
