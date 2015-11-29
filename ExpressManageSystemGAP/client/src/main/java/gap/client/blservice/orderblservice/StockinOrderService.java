package gap.client.blservice.orderblservice;

import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface StockinOrderService {
	public StockinOrderVO create(List<ExpressOrderVO> orders,
			StockinOrderVO orderinfo);

	public ResultMessage save(StockinOrderVO order);

	public StockinOrderPO find(String id,String ins_id);
	
	public String getLocation(GoodsVO vo);

}
