package gap.client.bl.stockinorder;

import java.util.List;

import gap.client.blservice.orderblservice.StockinOrderService;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.util.ResultMessage;

public class StockinOrder implements StockinOrderService{
	LocationCal locationcal;
	
	public StockinOrder(LocationCal l){
		this.locationcal = l;
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
		return null;
	}

	@Override
	public StockinOrderVO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocation(GoodsVO vo) {
		// TODO Auto-generated method stub
		return vo.getLocation();
	}

	@Override
	public int getOrdersNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
