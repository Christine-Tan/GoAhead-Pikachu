package gap.client.blservice.inventoryblservice;

import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockCountVO;
import gap.client.vo.StockObVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface InventoryService {
	public List<GoodsVO> getOneSector(String ins_id, String sector_id);
	
	public List<GoodsVO> getOneSectorExisted(String ins_id, String sector_id);

	public int getTotalNum(String ins_id);

	public ResultMessage setAlarm(double alarmValue, String ins_id);

	public double getAlarm(String ins_id);
	
	public String Alarm();

	public ResultMessage distributeSector(String beginColumn, String endColumn,
			String toSector);

	public void initialadd(GoodsVO vo);

	public void initialdelete(String id);

	public void initialmodify(GoodsVO vo);

	public ResultMessage initialflush();

	public ResultMessage stockIn(GoodsVO vo);
	
	public String getNextLocation(String ins_id,String sector_id);

	public ResultMessage stockOut(String id);

	

}
