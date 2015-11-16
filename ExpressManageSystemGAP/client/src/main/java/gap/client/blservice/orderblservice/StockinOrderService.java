package gap.client.blservice.orderblservice;

import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface StockinOrderService {
	public StockinOrderVO create(List<ExpressOrderVO> orders,
			StockinOrderVO orderinfo);

	public ResultMessage save(StockinOrderVO order);

	public StockinOrderVO find(String id);
	
	public String getLocation(GoodsVO vo);
}
