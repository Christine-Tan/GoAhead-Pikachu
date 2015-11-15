package gap.common.po;

import java.util.ArrayList;
import java.util.List;

import gap.common.util.ResultMessage;
import gap.common.util.SectorType;

public class SectorFixedPO {
	// 分区类型
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

	// 快递list
	private ArrayList<GoodsPO> goodsList;

	public ResultMessage add(GoodsPO goods) {
		for (GoodsPO g : this.goodsList) {
			if (g.getExpressorder_id().equals(goods.getExpressorder_id())) {
				return ResultMessage.EXITED;
			}
		}
		this.goodsList.add(goods);
		return ResultMessage.SUCCEED;
	}

	public ResultMessage add(List<GoodsPO> goodsList) {
		for (GoodsPO g : goodsList) {
			this.goodsList.add(g);
		}
		return ResultMessage.SUCCEED;
	}

	public ResultMessage delete(String id) {
		for (GoodsPO g : this.goodsList) {
			if (g.getExpressorder_id().equals(id)) {
				this.goodsList.remove(g);
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	public ResultMessage delete(List<String> ids) {
		for (String id : ids) {
			delete(id);
			ids.remove(id);
		}
		if (ids.isEmpty()) {
			return ResultMessage.SUCCEED;
		} else {
			return ResultMessage.NOTFOUND;
		}
	}

	public ResultMessage modify(GoodsPO goods) {
		for (GoodsPO g : this.goodsList) {
			if (g.getExpressorder_id().equals(goods.getExpressorder_id())) {
				this.goodsList.remove(g);
				this.goodsList.add(goods);
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	public ResultMessage modify(List<GoodsPO> goodsList) {
		for (GoodsPO g : goodsList) {
			modify(g);
		}
		return ResultMessage.SUCCEED;
	}

	public int getIndex(String location) {
		return 0;
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

	public ArrayList<GoodsPO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(ArrayList<GoodsPO> goodsList) {
		this.goodsList = goodsList;
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
}
