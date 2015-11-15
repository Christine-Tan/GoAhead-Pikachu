package gap.common.po;

import gap.common.util.SectorType;

public class SectorFlexPO {
	public SectorType type;
	// 警戒值，百分比
	private double alarmVal;

	// 分区存放快递最大件数
	private int maxCapacity;

	// 分区占用比
	private double used;

	// 排数
	private int rows;

	// 一排中架子个数
	private int shelves;

	// 一架中位置个数
	private int units;
	
	//各架分配情况
	private SectorType[][] usedState;

	public SectorType getType() {
		return type;
	}

	public void setType(SectorType type) {
		this.type = type;
	}

	public double getAlarmVal() {
		return alarmVal;
	}

	public void setAlarmVal(double alarmVal) {
		this.alarmVal = alarmVal;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public double getUsed() {
		return used;
	}

	public void setUsed(double used) {
		this.used = used;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getShelves() {
		return shelves;
	}

	public void setShelves(int shelves) {
		this.shelves = shelves;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public SectorType[][] getUsedState() {
		return usedState;
	}

	public void setUsedState(SectorType[][] usedState) {
		this.usedState = usedState;
	}
	
	
}
