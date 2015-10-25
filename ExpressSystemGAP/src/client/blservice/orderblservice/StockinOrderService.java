package client.blservice.orderblservice;

import java.util.List;

import po.ResultMessage;
import client.vo.StockinOrderVO;
import client.vo.ExpressOrderVO;

public interface StockinOrderService {
	public StockinOrderVO create(List<ExpressOrderVO> orders,
			StockinOrderVO orderinfo);

	public ResultMessage save(StockinOrderVO order);

	public StockinOrderVO find(String id);
}
