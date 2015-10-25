package po;

import java.io.Serializable;

public class DistancePO implements Serializable {
	String startCity;
	String endCity;
	double lngStart, latStart, lngEnd, latEnd;
	double distance;

	public DistancePO(String sc, String ec, double x1, double y1, double x2,
			double y2) {
		startCity = sc;
		endCity = ec;
		lngStart = x1;
		latStart = y1;
		lngEnd = x2;
		latEnd = y2;
		distance = getDistance(startCity, endCity);
	}

	public double getDistance(String startCity, String endCity) {
		distance = cal(lngStart, latStart, lngEnd, latEnd);
		return distance;
	}

	public double cal(double x1, double y1, double x2, double y2) {
		double result = 0.0;
		return result;
	}

	/**
	 * @return startCity
	 */
	public String getStartCity() {
		return startCity;
	}

	/**
	 * @param startCity Ҫ���õ� startCity
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
	 * @param endCity Ҫ���õ� endCity
	 */
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	/**
	 * @return lngStart
	 */
	public double getLngStart() {
		return lngStart;
	}

	/**
	 * @param lngStart Ҫ���õ� lngStart
	 */
	public void setLngStart(double lngStart) {
		this.lngStart = lngStart;
	}

	/**
	 * @return latStart
	 */
	public double getLatStart() {
		return latStart;
	}

	/**
	 * @param latStart Ҫ���õ� latStart
	 */
	public void setLatStart(double latStart) {
		this.latStart = latStart;
	}

	/**
	 * @return lngEnd
	 */
	public double getLngEnd() {
		return lngEnd;
	}

	/**
	 * @param lngEnd Ҫ���õ� lngEnd
	 */
	public void setLngEnd(double lngEnd) {
		this.lngEnd = lngEnd;
	}

	/**
	 * @return latEnd
	 */
	public double getLatEnd() {
		return latEnd;
	}

	/**
	 * @param latEnd Ҫ���õ� latEnd
	 */
	public void setLatEnd(double latEnd) {
		this.latEnd = latEnd;
	}

	/**
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance Ҫ���õ� distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
