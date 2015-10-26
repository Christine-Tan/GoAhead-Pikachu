package stub_drivers.dataservice.inventory;

import java.util.ArrayList;
import java.util.List;

import po.DeliveryOrderPO;
import po.ExpressOrderPO;
import util.ResultMessage;
import dataservice.inventorydataservice.InventoryDataService;

public class InventoryDataService_stub implements InventoryDataService{
	private List<ExpressOrderPO> list;
	private int alarmValue;
	
	public InventoryDataService_stub(){
		list = new ArrayList<ExpressOrderPO>();
	}

	@Override
	public ResultMessage add(ExpressOrderPO expressorder) {
		// TODO 自动生成的方法存根
		for (ExpressOrderPO order : list)
			if (order.getOrder_id().equals(expressorder.getOrder_id()))
				return ResultMessage.EXITED;
		list.add(expressorder);
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage delete(String expressorder_id) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOrder_id().equals(expressorder_id)) {
				list.remove(i);
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	@Override
	public ResultMessage modify(ExpressOrderPO expressorder, String location) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOrder_id().equals(expressorder.getOrder_id())) {
			//	list.get(i).setLocation(location);
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	@Override
	public ExpressOrderPO find(String expressorder_id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOrder_id().equals(expressorder_id)) 
				return list.get(i);
		}
		return null;
	}

	@Override
	public ResultMessage setAlarm(int alarmValue) {
		// TODO 自动生成的方法存根
		this.alarmValue = alarmValue;
		return ResultMessage.SUCCEED;
	}

	@Override
	public int getAlarm() {
		// TODO 自动生成的方法存根
		return this.alarmValue;
	}

}
