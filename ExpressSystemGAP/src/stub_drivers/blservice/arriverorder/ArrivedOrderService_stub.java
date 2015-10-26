package stub_drivers.blservice.arriverorder;

import java.util.List;

import po.ArrivedOrderPO;
import stub_drivers.dataservice.arrivedorderdata.ArrivedOrderDataService_stub;
import util.ResultMessage;
import client.blservice.orderblservice.ArrivedOrderService;
import client.vo.ArrivedOrderVO;
import client.vo.ExpressOrderVO;

public class ArrivedOrderService_stub implements ArrivedOrderService {

	ArrivedOrderDataService_stub datastub;

	public ArrivedOrderService_stub() {
		datastub = new ArrivedOrderDataService_stub();
	}

	@Override
	public ArrivedOrderVO create(List<ExpressOrderVO> orders,
			ArrivedOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return orderinfo;
	}

	@Override
	public ResultMessage save(ArrivedOrderVO order) {
		// TODO 自动生成的方法存根
		return datastub.add(toPO(order));
	}

	@Override
	public ArrivedOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(id));
	}

	private ArrivedOrderVO getVO(ArrivedOrderPO po) {
		if (po == null)
			return null;
		return new ArrivedOrderVO(po.getOrders(), po.getTime(), po.getId());
	}

	private ArrivedOrderPO toPO(ArrivedOrderVO vo) {
		if (vo == null)
			return null;
		return new ArrivedOrderPO(vo.getOrders(), vo.getTime(), vo.getId());
	}

}
