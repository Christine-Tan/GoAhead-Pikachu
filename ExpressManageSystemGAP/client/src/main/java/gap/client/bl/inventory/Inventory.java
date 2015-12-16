package gap.client.bl.inventory;

import gap.client.blservice.inventoryblservice.InventoryService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.ExpressOrderDataController;
import gap.client.datacontroller.InventoryDataController;
import gap.client.datacontroller.StockinOrderDataController;
import gap.client.datacontroller.StockoutOrderDataController;
import gap.client.util.AbstractOperation;
import gap.client.util.Operation;
import gap.client.util.WareHouseSize;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockCountVO;
import gap.client.vo.StockObVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryService {
	private static final String ADD = "addGoods", DELETE = "deleteGoods",
			MODIFY = "modifyGoods";
	List<Operation> operations;
	InventoryDataController inventoryData;
	int shelf = WareHouseSize.SHELF.getSize();
	int unit = WareHouseSize.UNIT.getSize();

	public Inventory() {
		inventoryData = ControllerFactory.getInventoryDataController();
		operations = new ArrayList<Operation>();
	}

	// @Override
	// public List<GoodsVO> getOneSector(String ins_id,String sector_id) {
	// List<GoodsPO> poList = inventoryData.getOneSector(sector_id, ins_id);
	// List<GoodsVO> voList = GoodsVO.toVOList(poList);
	// return voList;
	// }

	@Override
	public int getTotalNum(String ins_id){
		int num = 0;
		List<GoodsPO> list = new ArrayList<GoodsPO>();
		list = inventoryData.getOneSector(ins_id+"0", ins_id);
		if(list!=null){
			num += list.size();
		}else{
			return num;
		}
		
		list = inventoryData.getOneSector(ins_id+"1", ins_id);
		if(list!=null){
			num += list.size();
		}else{
			return num;
		}
		
		list = inventoryData.getOneSector(ins_id+"2", ins_id);
		if(list!=null){
			num += list.size();
		}else{
			return num;
		}
		
		list = inventoryData.getOneSector(ins_id+"3", ins_id);
		if(list!=null){
			num += list.size();
		}else{
			return num;
		}
		
		
		return num;
	}

	@Override
	public List<GoodsVO> getOneSector(String ins_id, String sector_id) {
		// TODO Auto-generated method stub
		List<GoodsPO> list = new ArrayList<GoodsPO>();
		list = inventoryData.getOneSector(sector_id, ins_id);
		return GoodsVO.toVOList(list);
	}

	@Override
	public List<GoodsVO> getOneSectorExisted(String ins_id, String sector_id) {
		// TODO Auto-generated method stub
		List<GoodsPO> list = new ArrayList<GoodsPO>();
		list = inventoryData.getOneSectorExisted(sector_id,
				ins_id);
		return GoodsVO.toVOList(list);
	}
	
	@Override
	public double getOneShelfRatio(String position, String sector_id) {
		// TODO Auto-generated method stub
		int num = inventoryData.getOneShelfNum(position, sector_id);
		int units = WareHouseSize.UNIT.getSize();
		return num*1.0/units*100;
	} 

	@Override
	public ResultMessage setAlarm(double alarmValue, String ins_id) {
		// TODO Auto-generated method stub
//		System.out.println(alarmValue);
		return inventoryData.setAlarm(alarmValue, ins_id);
	}

	@Override
	public double getAlarm(String ins_id) {
		// TODO Auto-generated method stub
		// System.out.println("Inventory");
		System.out.println(inventoryData.getAlarm(ins_id));
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
	public ResultMessage stockOut(String id) {
		// TODO Auto-generated method stub
		return inventoryData.delete(id);

	}

	@Override
	public ResultMessage stockIn(GoodsVO vo) {
		// TODO Auto-generated method stub
		return inventoryData.add(vo.toPO());
	}

	@Override
	public String getNextLocation(String ins_id, String sector_id) {
		// TODO Auto-generated method stub
		int size = WareHouseSize.TOTAL.getSize();
		boolean isFull = false;
		boolean[] isUsed = new boolean[size];

		List<GoodsPO> goods = inventoryData.getOneSector(sector_id, ins_id);
		if(goods!=null&&goods.size()>=size){
			isFull = true;
			goods = inventoryData.getOneSector(ins_id+"0",ins_id);
		}
		if (goods != null) {
			for (GoodsPO po : goods) {
				int i = locationToInt(po.getLocation());
				isUsed[i - 1] = true;
			}
			int i;
			for (i = 0; isUsed[i] == true; i++);
			
			String temp = getLocation(i + 1);
			if(isFull){
				return "f"+temp;
			}else{
				return temp;
			}
			
		} else {
			
			String temp = getLocation(1);
			if(isFull){
				return "f"+temp;
			}else{
				return temp;
			}
		}

	}

	public int locationToInt(String location) {
		String[] detail = location.split(",");
		int num = 0;
		if (detail.length == 3) {
			num += (detail[0].charAt(0) - 'A') * shelf * unit;
			num += (detail[1].charAt(0) - 'A') * unit;
			num += Integer.parseInt(detail[2]);
			return num;
		}
		return -1;
	}

	public String getLocation(int num) {
		if (num > 0 && num <= WareHouseSize.TOTAL.getSize()) {
			int[] size = new int[3];
			size[0] = num/(unit * shelf);
//			System.out.println(size[0]);
			num -= size[0] * unit * shelf;
//			System.out.println(num);
			size[1] = num / unit;
			num -= size[1] * unit;
			if (num == 0) {
				size[1]--;
				size[2] = unit;
			} else {
				size[2] = num;
			}
			String temp = size[2]+"";
			

			String l = (char) (size[0] + 'A') + "," + (char) (size[1] + 'A')
					+ "," + temp;

			return l;
		}
		System.out.println("location: wrong number");
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
