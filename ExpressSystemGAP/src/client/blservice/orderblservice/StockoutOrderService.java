package client.blservice.orderblservice;

import java.util.List;

import po.ResultMessage;
import client.vo.StockoutOrderVO;
import client.vo.ExpressOrderVO;

public interface StockoutOrderService {
	public StockoutOrderVO create(List<ExpressOrderVO> orders,
			StockoutOrderVO orderinfo);

	public ResultMessage save(StockoutOrderVO order);

	public StockoutOrderVO find(String id);
}
