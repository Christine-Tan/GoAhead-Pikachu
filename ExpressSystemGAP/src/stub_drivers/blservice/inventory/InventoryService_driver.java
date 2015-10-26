package stub_drivers.blservice.inventory;

import java.util.ArrayList;

import client.blservice.inventoryblservice.InventoryService;
import client.vo.ExpressOrderVO;
import client.vo.GoodsVO;
import client.vo.StockCheckVO;
import client.vo.StockObVO;
import client.vo.StockinOrderVO;
import client.vo.StockoutOrderVO;
import po.GoodsPO;
import stub_drivers.dataservice.inventory.InventoryDataService_driver;
import stub_drivers.dataservice.inventory.InventoryDataService_stub;
import util.ExpressType;
import util.ResultMessage;
import dataservice.inventorydataservice.InventoryDataService;

public class InventoryService_driver {
	private void driver(InventoryService inventory) {
		ExpressOrderVO order1 = new ExpressOrderVO("yyf", "nju", "software",
				"15520065137", "txy", "nju", "software", "110",
				ExpressType.STANDARD, null, false, "0000000001", "0011001",
				null);
		ExpressOrderVO order2 = new ExpressOrderVO("shenbin", "nju",
				"software", "119", "plw", "nju", "software", "120",
				ExpressType.EXPRESS, null, false, "0000000002", null, "0010001");
		
		
		System.out.println(inventory.stockIn(order1));
		System.out.println(inventory.stockIn(order2));
		if(inventory.setAlarm(80).equals(ResultMessage.SUCCEED))
			System.out.println("setAlarm succeed");
		System.out.println(inventory.getAlarm());
		
		StockCheckVO stockCheck =  inventory.countStock();
		StockObVO stockOb = inventory.observeStock("20151025","20151026");
		ArrayList<String> list = new ArrayList<String>();
		list.add(order1.getOrder_id());
		list.add(order2.getOrder_id());
		StockinOrderVO stockinOrder = inventory.createStockinOrder(list);
		
		GoodsVO goods1 = new GoodsVO(order1.getOrder_id(), "A区甲排1位", "car", "20151026");
		ExpressOrderVO goods3 = inventory.getSingleExpressOrder(order1.getOrder_id());
		if(inventory.initialadd(goods1).equals(ResultMessage.SUCCEED))
			System.out.println("add succeed");
		goods1.setSector("plane");
		
		if(inventory.initialmodify(goods1).equals(ResultMessage.SUCCEED))
			System.out.println("modefy succeed");
		if(inventory.initialdelete(goods1.getExpressorder_id()).equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		
		if(inventory.initialmodify(goods1).equals(ResultMessage.NOTFOUND))
			System.out.println("modefy failed,not found");
		if(inventory.initialdelete(goods1.getExpressorder_id()).equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
		
		
		
		
		ArrayList<ExpressOrderVO> orderlist = new ArrayList<ExpressOrderVO>();
		inventory.stockOut("上海", "car", order1.getOrder_id());
		inventory.stockOut("上海", "car", order2.getOrder_id());
		StockoutOrderVO stockoutOrder = inventory.createStockoutOrder(orderlist);
		
		System.out.println(inventory.Alarm());
		
		inventory.distributeSector("甲排", "乙排", "plane");
	}
	public static void main(String[] args){
		InventoryService inventory = new InventoryService_stub();
		InventoryService_driver driver = new InventoryService_driver();
		driver.driver(inventory);
	}
}
