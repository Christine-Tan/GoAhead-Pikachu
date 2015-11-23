package gap.common.dataservice.expressorderdataservice;

import gap.common.po.ExpressOrderModifyPO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ExpressOrderDataService extends Remote {
	/**
	 * 添加ExpressOrder记录
	 * @param po
	 * @return
	 */
	public ResultMessage add(ExpressOrderPO po, String courier_id)
			throws RemoteException;

	/**
	 * 根据订单号查询订单
	 * @param order_id
	 * @return
	 */
	public ExpressOrderPO find(String order_id) throws RemoteException;

	/**
	 * 改变已存在的订单信息
	 * @param po
	 * @return
	 */
	public ResultMessage modify(ExpressOrderModifyPO po) throws RemoteException;

	/**
	 * 查找即将达到对应id的机构的订单
	 * @param ins_id
	 * @return
	 */
	public List<ExpressOrderPO> findArrivingOrders(String ins_id)
			throws RemoteException;

	/**
	 * 查找属于对应id的机构的订单
	 * @param ins_id
	 * @return
	 */
	public List<ExpressOrderPO> findCurrentOrders(String ins_id)
			throws RemoteException;

	/**
	 * 查找对应id的装车单的订单
	 * @param loadorder_id
	 * @return
	 */
	public List<ExpressOrderPO> findLoadOrders(String loadorder_id)
			throws RemoteException;

	/**
	 * 查找对应id的派件单的订单
	 * @param deliveryorder_id
	 * @return
	 */
	public List<ExpressOrderPO> findDeliveryOrders(String deliveryorder_id)
			throws RemoteException;

	/**
	 * 查找对应id的到达单的订单
	 * @param arrivedorder_id
	 * @return
	 */
	public List<ExpressOrderPO> findArrivedOrders(String arrivedorder_id)
			throws RemoteException;

	/**
	 * 为对应订单号的订单添加状态信息
	 * @param order_id
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addState(String order_id, String state)
			throws RemoteException;

	/**
	 * 根据订单号返回状态信息
	 * @param order_id
	 * @return
	 * @throws RemoteException
	 */
	public List<String> getState(String order_id) throws RemoteException;

	/**
	 * 设置到达单信息
	 * @param order_id
	 * @param stateMessage
	 * @return
	 */
	public ResultMessage setArrived(String order_id, String ins_id,
			String stateMessage);
}
