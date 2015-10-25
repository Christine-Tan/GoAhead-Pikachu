package client.blservice.inventoryblservice;

import java.util.List;



import po.ExpressOrderPO;
import util.ResultMessage;
import client.vo.StockCheckVO;
import client.vo.StockObVO;
import client.vo.StockinOrderVO;
import client.vo.StockoutOrderVO;

public interface InventoryService {
	/**
	 * 查看库存信息，一个时间段内出入库数量
	 * @param begin
	 * @param end
	 * @return
	 */
	public StockObVO observeStock(String begin,String end);
	
	/**
	 * 库存盘点
	 * @return
	 */
	public StockCheckVO countStock();
	
	/**
	 * 设置警戒值
	 * @param alarmValue
	 * @return
	 */
	public ResultMessage setAlarm (int alarmValue);
	
	/**
	 * 调整库存分区，选择分配区域及分配给的分区
	 * @param beginColumn
	 * @param endColumn
	 * @param toSector
	 * @return
	 */
	public ResultMessage distributeSector(String beginColumn,String endColumn,String toSector);
	
	/**
	 * 库存信息初始化，增删改
	 * @param expressorder
	 * @param location
	 * @return
	 */
	public ResultMessage initialadd (ExpressOrderPO expressorder,String location);
	
	public ResultMessage initialdelete(String expressorder_id);
	
	public ResultMessage initialmodify (ExpressOrderPO expressorder,String location);
	
	/**
	 * 快递入库
	 * @param expressorder
	 * @return
	 */
	
	public String stockIn(ExpressOrderPO expressorder);
	
	/**
	 * 快递出库，填写快递编号设置目的地，货运方式
	 * @param destination
	 * @param transportation
	 * @param expressorder_id
	 */
	public void stockOut(String destination,String transportation,String expressorder_id);
	
	/**
	 * 生成入库单
	 * @param expressorders
	 * @return
	 */
	public StockinOrderVO createStockinOrder(List<ExpressOrderPO> expressorders);
	
	/**
	 * 生成出库单
	 * @param expressorders
	 * @return
	 */
	public StockoutOrderVO createStockoutOrder(List<ExpressOrderPO> expressorders);
	
	/**
	 * 查找单个快递
	 * @param expressorder_id
	 * @return
	 */
	public ExpressOrderPO getSingleExpressOrder(String expressorder_id);
	
}
