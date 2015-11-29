package gap.client.bl.inventory;

import java.util.List;

import gap.client.blservice.inventoryblservice.InventoryService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.inventorydata.InventoryDataController;
import gap.client.datacontroller.orderdata.ArrivedOrderDataController;
import gap.client.datacontroller.orderdata.StockinOrderDataController;
import gap.client.datacontroller.orderdata.StockoutOrderDataController;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockCountVO;
import gap.client.vo.StockObVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;

public class Inventory implements InventoryService {
	InventoryDataController inventoryData;
	StockinOrderDataController stockinOrderData;
	StockoutOrderDataController stockoutOrderData;

	public Inventory() {
		inventoryData = ControllerFactory.getInventoryDataController();
	}

	@Override
	public StockObVO observeStock(String beginDate, String endDate,
			String ins_id) {
		// TODO Auto-generated method stub
		StockObVO vo = new StockObVO();
		vo.setInList(stockinOrderData.getRequired(beginDate, endDate, ins_id));
		vo.setOutList(stockoutOrderData.getRequired(beginDate, endDate, ins_id));

		return vo;
	}

	@Override
	public StockCountVO countStock(String ins_id) {
		// TODO Auto-generated method stub
		StockCountVO vo = new StockCountVO();
		vo.setFlexList(inventoryData.getOneSector(ins_id+"0", ins_id));
		vo.setCarList(inventoryData.getOneSector(ins_id+"1", ins_id));
		vo.setTrainList(inventoryData.getOneSector(ins_id+"2", ins_id));
		vo.setPlaneList(inventoryData.getOneSector(ins_id+"3", ins_id));
		return vo;
	}

	@Override
	public ResultMessage setAlarm(double alarmValue, String ins_id) {
		// TODO Auto-generated method stub
		return inventoryData.setAlarm(alarmValue, ins_id);
	}

	@Override
	public double getAlarm(String ins_id) {
		// TODO Auto-generated method stub
		return inventoryData.getAlarm(ins_id);
	}

	@Override
	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage initialadd(GoodsVO vo) {
		// TODO Auto-generated method stub
		return inventoryData.add(vo.toPO());
	}

	@Override
	public ResultMessage initialdelete(String id) {
		// TODO Auto-generated method stub
		return inventoryData.delete(id);
	}

	@Override
	public ResultMessage initialmodify(GoodsVO vo) {
		// TODO Auto-generated method stub
		return inventoryData.modify(vo.toPO());
	}

	@Override
	public List<ExpressOrderVO> getArrivingOrders(String ins_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stockIn(ExpressOrderVO expressorder, String ins_id) {
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
	public StockoutOrderVO createStockoutOrder(List<GoodsVO> expressorders) {
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
