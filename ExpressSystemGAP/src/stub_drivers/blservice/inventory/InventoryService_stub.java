package stub_drivers.blservice.inventory;

import java.util.List;




import po.ExpressOrderPO;
import util.ResultMessage;
import client.blservice.inventoryblservice.InventoryService;
import client.vo.ExpressOrderVO;
import client.vo.GoodsVO;
import client.vo.StockCheckVO;
import client.vo.StockObVO;
import client.vo.StockinOrderVO;
import client.vo.StockoutOrderVO;

public class InventoryService_stub implements InventoryService{

	@Override
	public StockObVO observeStock(String begin, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockCheckVO countStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setAlarm(int alarmValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage initialadd(GoodsVO expressorder, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage initialdelete(String expressorder_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage initialmodify(GoodsVO expressorder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpressOrderVO> getArrivingOrders(String institution_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stockIn(ExpressOrderVO expressorder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stockOut(String destination, String transportation,
			String expressorder_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StockinOrderVO createStockinOrder(List<String> expressorders_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockoutOrderVO createStockoutOrder(
			List<ExpressOrderVO> expressorders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressOrderVO getSingleExpressOrder(String expressorder_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
