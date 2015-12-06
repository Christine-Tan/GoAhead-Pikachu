package gap.client.bl.order;

import gap.client.blservice.orderblservice.StockinOrderService;
import gap.client.datacontroller.ArrivedOrderDataController;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.StockinOrderDataController;
import gap.client.util.LocalInfo;
import gap.client.vo.ArrivedOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

import java.util.List;

public class StockinOrder implements StockinOrderService {
	StockinOrderDataController stockinData;
	ArrivedOrderDataController arrivedData;

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
		String date = order.getInDate().replaceAll("-", "");
		String pre = LocalInfo.ins_id + date;
//		String id = "" + loadDataController.nextId(LocalInfo.ins_id + date);
//		while (id.length() < 5)
//			id = "0" + id;
//		order.order_id = pre + id;
		return stockinData.add(order.toPO());
	}

	@Override
	public StockinOrderVO find(String id,String ins_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocation(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArrivedOrderVO> getArrivedOrderVO(String ins_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockinOrderVO> getRequired(String beginDate, String endDate,
			String ins_id) {
		// TODO Auto-generated method stub
		List<StockinOrderPO> list = stockinData.getRequired(beginDate, endDate, ins_id);
		return StockinOrderVO.toVOList(list);
	}

	@Override
	public int getTotalNum(List<StockinOrderVO> list) {
		// TODO Auto-generated method stub
		int num = 0;
		for(StockinOrderVO vo:list){
			num += vo.getNum();
		}
		return num;
	}


}
