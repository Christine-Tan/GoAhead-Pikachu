package client.blservice.expressorderblservice;

import java.util.List;




import util.ReceiveInfo;
import util.ResultMessage;
import client.vo.ExpressOrderVO;
import client.vo.StateVO;

public interface ExpressOrderService {
	/**
	 * 获得订单货运状态
	 * @param order_id
	 * @return
	 */
	public StateVO getState(String order_id);

	public List<ExpressOrderVO> getArrivingOrders(String ins_id);

	public List<ExpressOrderVO> getCurrentOrders(String ins_id);

	public util.ResultMessage setArrivedOrders(List<ExpressOrderVO> orders,
			String ins_id);

	public ResultMessage setOffOders(List<ExpressOrderVO> orders, String ins_id);

	public ExpressOrderVO createOrder(ExpressOrderVO order_info);

	public ResultMessage save(ExpressOrderVO order);

	public ResultMessage receiveOrder(String order_id, ReceiveInfo receiveInfo);
}
