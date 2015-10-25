package client.blservice.inventoryblservice;

import java.util.List;

import po.ExpressOrderPO;
import po.ResultMessage;
import client.vo.StockCheckVO;
import client.vo.StockObVO;
import client.vo.StockinOrderVO;
import client.vo.StockoutOrderVO;

public interface InventoryService {
	public StockObVO observeStock(String begin,String end);
	
	public StockCheckVO countStock();
	
	public ResultMessage setAlarm (int alarmValue);
	
	public ResultMessage distributeSector(String beginColumn,String endColumn,String toSector);
	
	public ResultMessage initialadd (ExpressOrderPO expressorder,String location);
	
	public ResultMessage initialdelete(String expressorder_id);
	
	public ResultMessage initialmodify (ExpressOrderPO expressorder,String location);
	
	public String stockIn(ExpressOrderPO expressorder);
	
	public StockinOrderVO createStockinOrder(List<ExpressOrderPO> expressorders);
	
	public StockoutOrderVO createStockoutOrder(List<ExpressOrderPO> expressorders);
	
	public ExpressOrderPO getSingleExpressOrder(String expressorder_id);
	
}
