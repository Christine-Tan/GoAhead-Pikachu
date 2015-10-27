package gap.common.po;

import java.io.Serializable;

public class PricePO implements Serializable {
	// 经济：标准：特快的比例式
	String rate;
	// 比例基准
	double base;
	// 城市编号
	String cityId;

	public PricePO() {

	}

	public PricePO(String id, String rate, double base) {
		this.rate = rate;
		this.base = base;
		cityId = id;
	}

	/**
	 * @return rate
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate Ҫ���õ� rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * @return base
	 */
	public double getBase() {
		return base;
	}

	/**
	 * @param base Ҫ���õ� base
	 */
	public void setBase(double base) {
		this.base = base;
	}

	/**
	 * @return cityId
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * @param cityId Ҫ���õ� cityId
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}
