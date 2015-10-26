package stub_drivers.blservice.stockin;

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
		return new StockinOrderVO(null, "20151026", "北京", "plane", "A区甲排1位");
	}

	@Override
	public ResultMessage save(StockinOrderVO order) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCEED;
	}

	@Override
	public StockinOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return new StockinOrderVO(null, "20151026", "北京", "plane", "A区甲排1位");
	}

}
