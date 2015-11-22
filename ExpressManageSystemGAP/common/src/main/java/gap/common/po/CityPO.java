package gap.common.po;

import java.io.Serializable;

public class CityPO implements Serializable {
	// 城市名称
	String city;
   //城市经纬度
	double longitude,latitude;
	public CityPO(String name) {
		city = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
