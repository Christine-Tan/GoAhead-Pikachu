package dataservice.inventorydataservice;

import po.ExpressOrderPO;
import po.ResultMessage;

public interface InventoryDataService {
	public ResultMessage add(ExpressOrderPO expressorder);
	
	public ResultMessage delete(String expressorder_id);
	
	public ResultMessage modify(ExpressOrderPO expressorder,String location);
	
	public ExpressOrderPO find(String expressorder_id);
	
	public ResultMessage setAlarm(int alarmValue);
	
	public int getAlarm();

}
