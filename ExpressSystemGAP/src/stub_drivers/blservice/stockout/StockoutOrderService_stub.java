package stub_drivers.blservice.stockout;

import java.util.List;


import util.ResultMessage;
import client.blservice.orderblservice.StockoutOrderService;
import client.vo.ExpressOrderVO;
import client.vo.StockoutOrderVO;

public class StockoutOrderService_stub implements StockoutOrderService{

	@Override
	public StockoutOrderVO create(List<ExpressOrderVO> orders,
			StockoutOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(StockoutOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockoutOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
