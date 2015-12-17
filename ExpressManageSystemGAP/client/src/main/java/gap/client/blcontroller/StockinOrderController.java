package gap.client.blcontroller;

import gap.client.bl.order.StockinOrder;
import gap.client.vo.StockinOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public class StockinOrderController {
	private static StockinOrder stockinOrder = new StockinOrder();
	

	public static ResultMessage save(StockinOrderVO vo) {
		if(vo.getGoods()==null||vo.getGoods().size()==0){
			return ResultMessage.FAILED;
		}else{
			return stockinOrder.save(vo);
		}
		

	}

	public static List<StockinOrderVO> getRequired(String beginDate,
			String endDate, String ins_id) {
		return stockinOrder.getRequired(beginDate, endDate, ins_id);
	}

	public static int getTotalNum(List<StockinOrderVO> list) {
		return stockinOrder.getTotalNum(list);
	}
	
	public static String getNextId(String cons){
		return stockinOrder.getNextId(cons);
	}
}
