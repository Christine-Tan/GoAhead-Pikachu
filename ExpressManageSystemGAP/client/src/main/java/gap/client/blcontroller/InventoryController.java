package gap.client.blcontroller;

import gap.client.bl.inventory.Inventory;
import gap.client.vo.GoodsVO;
import gap.common.util.ResultMessage;

public class InventoryController {
	private static Inventory inventory = new Inventory();

	public static ResultMessage setAlarmValue(double alarmValue, String ins_id) {
		return inventory.setAlarm(alarmValue, ins_id);
	}

	public static double getAlarmValue(String ins_id) {
		// System.out.println("InventoryController");
		return inventory.getAlarm(ins_id);
	}

	public static int getTotalNum(String ins_id) {
		return inventory.getTotalNum(ins_id);
	}
	
	public static String getNextLocation(String sector_id,String ins_id){
		return inventory.getNextLocation(ins_id, sector_id);
	}
	
	public static ResultMessage Stockin(GoodsVO vo){
		return inventory.stockIn(vo);
	}
	
	public static ResultMessage Stockout(GoodsVO vo){
		return inventory.stockOut(vo.getExpressorder_id());
	}
}
