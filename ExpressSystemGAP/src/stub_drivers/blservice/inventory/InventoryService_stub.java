package stub_drivers.blservice.inventory;

import java.util.List;


import po.ExpressOrderPO;
import util.ResultMessage;
import client.blservice.inventoryblservice.InventoryService;
import client.vo.StockCheckVO;
import client.vo.StockObVO;
import client.vo.StockinOrderVO;
import client.vo.StockoutOrderVO;

public class InventoryService_stub implements InventoryService{

	@Override
	public StockObVO observeStock(String begin, String end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockCheckVO countStock() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setAlarm(int alarmValue) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage initialadd(ExpressOrderPO expressorder, String location) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage initialdelete(String expressorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage initialmodify(ExpressOrderPO expressorder,
			String location) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String stockIn(ExpressOrderPO expressorder) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockinOrderVO createStockinOrder(List<ExpressOrderPO> expressorders) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockoutOrderVO createStockoutOrder(
			List<ExpressOrderPO> expressorders) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderPO getSingleExpressOrder(String expressorder_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void stockOut(String destination, String transportation,
			String expressorder_id) {
		// TODO 自动生成的方法存根
		
	}

}
