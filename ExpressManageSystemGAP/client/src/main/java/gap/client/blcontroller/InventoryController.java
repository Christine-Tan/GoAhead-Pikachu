package gap.client.blcontroller;

import gap.client.bl.inventory.Inventory;
import gap.common.util.ResultMessage;

public class InventoryController {
	private static Inventory inventory = new Inventory();
	
	public static ResultMessage setAlarmValue(double alarmValue,String ins_id){
		return inventory.setAlarm(alarmValue, ins_id);
	}
	
	public static double getAlarmValue(String ins_id){
//		System.out.println("InventoryController");
		return inventory.getAlarm(ins_id);
	}
}
