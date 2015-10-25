package client.blservice.orderblservice;

import java.util.List;



import util.ResultMessage;
import client.vo.DeliveryOrderVO;
import client.vo.ExpressOrderVO;

public interface DeliveryOrderService {
	public DeliveryOrderVO create(List<ExpressOrderVO> orders,
			DeliveryOrderVO orderinfo);

	public ResultMessage save(DeliveryOrderVO order);

	public DeliveryOrderVO find(String id);
}
