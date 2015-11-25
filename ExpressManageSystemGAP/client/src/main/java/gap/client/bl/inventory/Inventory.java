package gap.client.bl.inventory;

import java.util.List;

import gap.client.blservice.inventoryblservice.InventoryService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.inventorydata.InventoryDataController;
import gap.client.datacontroller.orderdata.ArrivedOrderDataController;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockCheckVO;
import gap.client.vo.StockObVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;

public class Inventory implements InventoryService {
	InventoryDataController inventoryData;

	public Inventory() {
		inventoryData = ControllerFactory.getInventoryDataController();
	}

	@Override
	public StockObVO observeStock(String begindate, String enddate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockCheckVO countStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setAlarm(double alarmValue) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public double getAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage initialadd(GoodsVO expressorder) {
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
	public String stockIn(ExpressOrderVO expressorder, String ins_center_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stockOut(String destination, String transportation,
			String expressorder_id, String ins_center_id) {
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

	@Override
	public String Alarm() {
		// TODO Auto-generated method stub
		return null;
	}

}
