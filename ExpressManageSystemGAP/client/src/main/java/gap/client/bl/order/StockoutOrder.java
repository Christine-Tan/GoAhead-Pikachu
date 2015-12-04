package gap.client.bl.order;

import gap.client.blservice.orderblservice.StockoutOrderService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.orderdata.StockoutOrderDataController;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public class StockoutOrder implements StockoutOrderService {
	StockoutOrderDataController stockoutData;

	public StockoutOrder() {
		stockoutData = ControllerFactory.getStockoutOrderDataController();
	}

	@Override
	public StockoutOrderVO create(List<ExpressOrderVO> orders,
			StockoutOrderVO orderinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(StockoutOrderVO order) {
		// TODO Auto-generated method stub
		return stockoutData.add(order.toPO());
	}

	@Override
	public StockoutOrderVO find(String id,String ins_id) {
		// TODO Auto-generated method stub
		return new StockoutOrderVO(stockoutData.find(id, ins_id));
	}

}
