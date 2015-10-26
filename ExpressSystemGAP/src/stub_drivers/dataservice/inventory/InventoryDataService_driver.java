package stub_drivers.dataservice.inventory;

import po.GoodsPO;
import po.StockoutOrderPO;
import util.ResultMessage;
import client.vo.GoodsVO;
import dataservice.inventorydataservice.InventoryDataService;



public class InventoryDataService_driver {
	private void driver(InventoryDataService inventoryData) {
		GoodsPO goods1 = new GoodsPO("0000000001", "A区甲排1位", "car", "20151026");
		GoodsPO goods2 = new GoodsPO("0000000002", "A区甲排2位", "car", "20151026");
		
		if(inventoryData.add(goods1).equals(ResultMessage.SUCCEED)){
			System.out.println("add succeed");
		}
		if(inventoryData.add(goods2).equals(ResultMessage.SUCCEED)){
			System.out.println("add succeed");
		}
		if (inventoryData.add(goods2).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,goods exited");
		}
		GoodsPO get = inventoryData.find("0000000001");
		if (get != null)
			System.out.println("find:Goods"+get.getExpressorder_id());
		
		GoodsPO get1 = inventoryData.find("0000000002");
		if (get1 != null)
			System.out.println("find:Goods"+get.getExpressorder_id());
		get1 = inventoryData.find("0000000003");
		if (get == null)
			System.out.println("find failed,not found");
	}
	public static void main(String[] args){
		InventoryDataService inventoryData = new InventoryDataService_stub();
		InventoryDataService_driver driver = new InventoryDataService_driver();
		driver.driver(inventoryData);
	}

	

}
