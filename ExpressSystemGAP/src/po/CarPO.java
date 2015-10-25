package po;

import java.io.Serializable;

public class CarPO implements Serializable {
	// 车辆编号
	private String car_id;
	// 车牌号
	private String car_num;
	// 服役时间
	private int serve_time;

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public int getServe_time() {
		return serve_time;
	}

	public void setServe_time(int serve_time) {
		this.serve_time = serve_time;
	}

}
