package dataservice.expressorderdataservice;

import java.util.List;



import po.ExpressOrderPO;
import util.ResultMessage;

public interface ExpressOrderDataService {
	/**
	 * 添加ExpressOrder记录
	 * @param po
	 * @return
	 */
	public ResultMessage add(ExpressOrderPO po);

	/**
	 * 根据订单号查询订单
	 * @param order_id
	 * @return
	 */
	public ExpressOrderPO find(String order_id);

	/**
	 * 改变已存在的订单信息
	 * @param po
	 * @return
	 */
	public ResultMessage modify(ExpressOrderPO po);

	/**
	 * 查找即将达到对应id的机构的订单
	 * @param ins_id
	 * @return
	 */
	public List<ExpressOrderPO> findArrivingOrders(String ins_id);

	/**
	 * 查找属于对应id的机构的订单
	 * @param ins_id
	 * @return
	 */
	public List<ExpressOrderPO> findCurrentOrders(String ins_id);

	/**
	 * 查找对应id的装车单的订单
	 * @param loadorder_id
	 * @return
	 */
	public List<ExpressOrderPO> findLoadOrders(String loadorder_id);

	/**
	 * 查找对应id的派件单的订单
	 * @param deliveryorder_id
	 * @return
	 */
	public List<ExpressOrderPO> findDeliveryOrders(String deliveryorder_id);

	/**
	 * 查找对应id的到达单的订单
	 * @param arrivedorder_id
	 * @return
	 */
	public List<ExpressOrderPO> findArrivedOrders(String arrivedorder_id);
}
