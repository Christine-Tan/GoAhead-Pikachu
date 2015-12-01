package gap.client.bl.order;

import java.util.List;

import gap.client.blservice.orderblservice.StockinOrderService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.orderdata.LoadOrderDataController;
import gap.client.datacontroller.orderdata.StockinOrderDataController;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

public class StockinOrder implements StockinOrderService {
	StockinOrderDataController stockinData;

	public StockinOrder() {
		stockinData = ControllerFactory.getStockinOrderDataController();
	}

	@Override
	public StockinOrderVO create(List<ExpressOrderVO> orders,
			StockinOrderVO orderinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(StockinOrderVO order) {
		// TODO Auto-generated method stub
		return stockinData.add(order.toPO());
	}

	@Override
	public StockinOrderVO find(String id,String ins_id) {
		// TODO Auto-generated method stub
		return new StockinOrderVO(stockinData.find(id, ins_id));
	}

	@Override
	public String getLocation(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
