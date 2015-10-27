package gap.common.util;

import java.io.Serializable;

public class CargoInfo implements Serializable {
	// 原件数量、重量、体积
	private int cargoNum, weight, volume;
	// 内件名称
	private String name;

	public CargoInfo() {

	}

	public CargoInfo(int cargoNum, int weight, int volume, String name) {
		this.cargoNum = cargoNum;
		this.weight = weight;
		this.volume = volume;
		this.name = name;
	}

	public int getCargoNum() {
		return cargoNum;
	}

	public void setCargoNum(int cargoNum) {
		this.cargoNum = cargoNum;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
