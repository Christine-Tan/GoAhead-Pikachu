package gap.stub_driver.blservice.stockin;

import gap.client.blservice.orderblservice.StockinOrderService;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.StockinOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

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
