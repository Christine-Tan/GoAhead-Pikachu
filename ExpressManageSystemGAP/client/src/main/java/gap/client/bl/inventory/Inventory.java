package gap.client.bl.inventory;

import gap.client.blservice.inventoryblservice.InventoryService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.ExpressOrderDataController;
import gap.client.datacontroller.InventoryDataController;
import gap.client.datacontroller.StockinOrderDataController;
import gap.client.datacontroller.StockoutOrderDataController;
import gap.client.util.AbstractOperation;
import gap.client.util.Operation;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockCountVO;
import gap.client.vo.StockObVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryService {
	private static final String ADD = "addGoods", DELETE = "deleteGoods", MODIFY = "modifyGoods";
	List<Operation> operations;
	InventoryDataController inventoryData;
	StockinOrderDataController stockinOrderData;
	StockoutOrderDataController stockoutOrderData;
	ExpressOrderDataController expressorderData;

	public Inventory() {
		inventoryData = ControllerFactory.getInventoryDataController();
		stockinOrderData = ControllerFactory.getStockinOrderDataController();
		stockoutOrderData = ControllerFactory.getStockoutOrderDataController();
		expressorderData = ControllerFactory.getExpressOrderDataController();
		operations = new ArrayList<Operation>();
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
	public int getOneSectorNum(String ins_id,String sector_id){
		return inventoryData.getOneSectorNum(sector_id, ins_id);
	}

	@Override
	public ResultMessage setAlarm(double alarmValue, String ins_id) {
		// TODO Auto-generated method stub
		return inventoryData.setAlarm(alarmValue, ins_id);
	}

	@Override
	public double getAlarm(String ins_id) {
		// TODO Auto-generated method stub
//		System.out.println("Inventory");
		return inventoryData.getAlarm(ins_id);
	}

	@Override
	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialadd(GoodsVO vo) {
		// TODO Auto-generated method stub
		operations.add(new AddOperation(vo.toPO()));
	}

	@Override
	public void initialdelete(String id) {
		// TODO Auto-generated method stub
		operations.add(new DeleteOperation(id));
	}

	@Override
	public void initialmodify(GoodsVO vo) {
		// TODO Auto-generated method stub
		operations.add(new ModifyOperation(vo.toPO()));
	}
	
	@Override
	public ResultMessage initialflush() {
		for (Operation ope : operations) {
			ResultMessage re = ope.excute();
			if (!re.equals(ResultMessage.SUCCEED)) {
				operations.clear();
				return re;
			}
		}
		operations.clear();
		return ResultMessage.SUCCEED;
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
	
	class AddOperation extends AbstractOperation {
		public AddOperation(Object args) {
			super(inventoryData, ADD, args);
		}
	}

	class DeleteOperation extends AbstractOperation {
		public DeleteOperation(Object args) {
			super(inventoryData, DELETE, args);
		}
	}

	class ModifyOperation extends AbstractOperation {
		public ModifyOperation(Object args) {
			super(inventoryData, MODIFY, args);
		}
	}

	
}
