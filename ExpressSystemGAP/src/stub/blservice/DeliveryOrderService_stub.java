package stub.blservice;

import java.util.List;

import po.DeliveryOrderPO;
import stub.dataservice.DeliveryOrderDataService_stub;
import util.ResultMessage;
import client.blservice.orderblservice.DeliveryOrderService;
import client.vo.DeliveryOrderVO;
import client.vo.ExpressOrderVO;

public class DeliveryOrderService_stub implements DeliveryOrderService {

	private DeliveryOrderDataService_stub datastub;

	public DeliveryOrderService_stub() {
		datastub = new DeliveryOrderDataService_stub();
	}

	@Override
	public DeliveryOrderVO create(List<ExpressOrderVO> orders,
			DeliveryOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return orderinfo;
	}

	@Override
	public ResultMessage save(DeliveryOrderVO order) {
		// TODO 自动生成的方法存根
		return datastub.add(getPO(order));
	}

	@Override
	public DeliveryOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(id));
	}

	private DeliveryOrderVO getVO(DeliveryOrderPO po) {
		return new DeliveryOrderVO();
	}

	private DeliveryOrderPO getPO(DeliveryOrderVO vo) {
		return new DeliveryOrderPO();
	}

}
