package stub_drivers.dataservice.inventory;

import java.util.ArrayList;
import java.util.List;

import po.DeliveryOrderPO;
import po.ExpressOrderPO;
import po.GoodsPO;
import util.ResultMessage;
import dataservice.inventorydataservice.InventoryDataService;

public class InventoryDataService_stub implements InventoryDataService{
	private List<GoodsPO> list;
	private double alarmValue;
	
	public InventoryDataService_stub(){
		list = new ArrayList<GoodsPO>();
	}

	@Override
	public ResultMessage add(GoodsPO expressorder) {
		// TODO 自动生成的方法存根
		for (GoodsPO order : list)
			if (order.getExpressorder_id().equals(expressorder.getExpressorder_id()))
				return ResultMessage.EXITED;
		list.add(expressorder);
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage delete(String expressorder_id) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getExpressorder_id().equals(expressorder_id)) {
				list.remove(i);
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	@Override
	public ResultMessage modify(GoodsPO expressorder) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getExpressorder_id().equals(expressorder.getExpressorder_id())) {
				list.get(i).setLocation(expressorder.getLocation());
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	@Override
	public GoodsPO find(String expressorder_id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getExpressorder_id().equals(expressorder_id)) 
				return list.get(i);
		}
		return null;
	}


	@Override
	public ResultMessage setAlarm(double alarmValue) {
		// TODO Auto-generated method stub
		this.alarmValue = alarmValue;
		return ResultMessage.SUCCEED;
	}

	@Override
	public double getAlarm() {
		// TODO Auto-generated method stub
		return this.getAlarm();
	}

}
