package gap.client.blcontroller;

import gap.client.bl.order.StockinOrder;
import gap.client.vo.StockinOrderVO;
import gap.common.util.ResultMessage;

public class StockinOrderController {
	private static StockinOrder stockinOrder;
	
	public static ResultMessage save(StockinOrderVO vo){
		return stockinOrder.save(vo);
		
	}
}
