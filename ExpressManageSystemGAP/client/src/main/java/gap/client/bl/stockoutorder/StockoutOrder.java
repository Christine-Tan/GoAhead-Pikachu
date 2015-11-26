package gap.client.bl.stockoutorder;

import java.util.List;

import gap.client.blservice.orderblservice.StockoutOrderService;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;

public class StockoutOrder implements StockoutOrderService{

	@Override
	public StockoutOrderVO create(List<ExpressOrderVO> orders,
			StockoutOrderVO orderinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(StockoutOrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockoutOrderVO find(String id,String ins_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOrdersNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
