package gap.client.blservice.expressorderblservice;

import gap.client.exception.InvalidInputException;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.StateVO;
import gap.common.util.ReceiveInfo;
import gap.common.util.ResultMessage;

import java.util.List;

public interface ExpressOrderService {
	/**
	 * 获得订单货运状态
	 * @param order_id
	 * @return
	 */
	public List<String> getState(String order_id) throws InvalidInputException;

	public ExpressOrderVO getOrder(String order_id)
			throws InvalidInputException;

	public ResultMessage modify(ExpressOrderVO vo);

	public List<ExpressOrderVO> getArrivingOrders(String ins_id)
			throws InvalidInputException;

	public List<ExpressOrderVO> getCurrentOrders(String ins_id)
			throws InvalidInputException;

	public ResultMessage setArrivedOrders(List<ExpressOrderVO> orders,
			String ins_id);

	public ResultMessage setOffOders(List<ExpressOrderVO> orders, String ins_id);

	public ExpressOrderVO createOrder(ExpressOrderVO order_info);

	public ResultMessage save(ExpressOrderVO order);

	public ResultMessage receiveOrder(String order_id, ReceiveInfo receiveInfo);
}
