package stub.dataservice;

import po.ExpressOrderPO;

import util.ResultMessage;
import dataservice.inventorydataservice.InventoryDataService;

public class InventoryDataService_stub implements InventoryDataService{

	@Override
	public ResultMessage add(ExpressOrderPO expressorder) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage delete(String expressorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modify(ExpressOrderPO expressorder, String location) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderPO find(String expressorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setAlarm(int alarmValue) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int getAlarm() {
		// TODO 自动生成的方法存根
		return 0;
	}

}
