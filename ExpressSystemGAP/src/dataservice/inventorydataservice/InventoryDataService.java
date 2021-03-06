package dataservice.inventorydataservice;

import po.ExpressOrderPO;
import po.GoodsPO;
import util.ResultMessage;


public interface InventoryDataService {
	public ResultMessage add(GoodsPO expressorder);
	
	public ResultMessage delete(String expressorder_id);
	
	public ResultMessage modify(GoodsPO expressorder);
	
	public GoodsPO find(String expressorder_id);
	
	/**
	 * 设置警戒值
	 * @param alarmValue
	 * @return
	 */
	public ResultMessage setAlarm(double alarmValue);
	
	/**
	 * 获得警戒值
	 * @return
	 */
	public double getAlarm();

}
