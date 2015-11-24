package gap.common.dataservice.expressorderdataservice;

import gap.common.po.ExpressOrderModifyPO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.CurrentOrderType;
import gap.common.util.ReceiveInfo;
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
	 * 获得未审批通过的订单
	 * @return
	 */
	public List<ExpressOrderPO> getUnpassedOrder() throws RemoteException;

	/**设置订单审批通过状态
	 * 
	 * @param order_id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setPassed(String order_id) throws RemoteException;

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
	public List<ExpressOrderPO> findCurrentOrders(String ins_id,
			CurrentOrderType type) throws RemoteException;

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
			String stateMessage) throws RemoteException;

	/**
	 * 设置装车单信息
	 * @param order_id
	 * @param ins_id
	 * @param stateMessage
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setLoad(String order_id, String ins_id,
			String stateMessage) throws RemoteException;

	/**
	 * 设置派送信息
	 * @param order_id
	 * @param delivery_id
	 * @param stateMessage
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setDelivery(String order_id, String delivery_id,
			String stateMessage) throws RemoteException;

	/**
	 * 设置收件信息
	 * @param order_id
	 * @param info
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setRecieved(String order_id, ReceiveInfo info)
			throws RemoteException;

	/**
	 * 获得某个快递员某天所收运费
	 * @param date
	 * @param delivery_id
	 * @return
	 * @throws RemoteException
	 */
	public double getDeliveryMoney(String date, String delivery_id)
			throws RemoteException;
}
