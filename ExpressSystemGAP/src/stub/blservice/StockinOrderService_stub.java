package stub.blservice;

import java.util.List;


import util.ResultMessage;
import client.blservice.orderblservice.StockinOrderService;
import client.vo.ExpressOrderVO;
import client.vo.StockinOrderVO;

public class StockinOrderService_stub implements StockinOrderService{

	@Override
	public StockinOrderVO create(List<ExpressOrderVO> orders,
			StockinOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(StockinOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockinOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
