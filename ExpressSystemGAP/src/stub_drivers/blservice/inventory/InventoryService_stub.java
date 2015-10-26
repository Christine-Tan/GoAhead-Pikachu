package stub_drivers.blservice.inventory;

import java.util.ArrayList;
import java.util.List;






import po.ExpressOrderPO;
import stub_drivers.dataservice.inventory.InventoryDataService_stub;
import util.ResultMessage;
import client.blservice.inventoryblservice.InventoryService;
import client.vo.ExpressOrderVO;
import client.vo.GoodsVO;
import client.vo.StockCheckVO;
import client.vo.StockObVO;
import client.vo.StockinOrderVO;
import client.vo.StockoutOrderVO;

public class InventoryService_stub implements InventoryService{
	InventoryDataService_stub datastub;

	@Override
	public StockObVO observeStock(String begin, String end) {
		// TODO Auto-generated method stub
		return new StockObVO();
	}

	@Override
	public StockCheckVO countStock() {
		// TODO Auto-generated method stub
		return new StockCheckVO();
	}

	@Override
	public ResultMessage setAlarm(double alarmValue) {
		// TODO Auto-generated method stub
		datastub.setAlarm(alarmValue);
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage initialadd(GoodsVO expressorder) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage initialdelete(String expressorder_id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage initialmodify(GoodsVO expressorder) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

	@Override
	public List<ExpressOrderVO> getArrivingOrders(String institution_id) {
		// TODO Auto-generated method stub
		return new ArrayList<ExpressOrderVO>();
	}

	@Override
	public String stockIn(ExpressOrderVO expressorder) {
		// TODO Auto-generated method stub
		return expressorder.getOrder_id();
	}

	@Override
	public void stockOut(String destination, String transportation,
			String expressorder_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StockinOrderVO createStockinOrder(List<String> expressorders_id) {
		// TODO Auto-generated method stub
		return new StockinOrderVO();
	}

	@Override
	public StockoutOrderVO createStockoutOrder(
			List<ExpressOrderVO> expressorders) {
		// TODO Auto-generated method stub
		return new StockoutOrderVO();
	}

	@Override
	public ExpressOrderVO getSingleExpressOrder(String expressorder_id) {
		// TODO Auto-generated method stub
		return new ExpressOrderVO();
	}

	
}
