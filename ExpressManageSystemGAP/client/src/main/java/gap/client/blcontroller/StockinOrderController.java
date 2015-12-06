package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.order.StockinOrder;
import gap.client.vo.StockinOrderVO;
import gap.common.util.ResultMessage;

public class StockinOrderController {
	private static StockinOrder stockinOrder;
	
	public static ResultMessage save(StockinOrderVO vo){
		return stockinOrder.save(vo);
		
	}
	
	public static List<StockinOrderVO> getRequired(String beginDate,String endDate,String ins_id){
		return stockinOrder.getRequired(beginDate, endDate, ins_id);
	}
	
	public static int getTotalNum(List<StockinOrderVO> list){
		return stockinOrder.getTotalNum(list);
	}
}
