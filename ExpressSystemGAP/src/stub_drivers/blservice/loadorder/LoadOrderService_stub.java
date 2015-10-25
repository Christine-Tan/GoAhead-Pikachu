package stub_drivers.blservice.loadorder;

import java.util.List;

import po.LoadOrderPO;
import stub_drivers.dataservice.loadorder.LoadOrderDataService_stub;
import util.ResultMessage;
import client.blservice.orderblservice.LoadOrderService;
import client.vo.ExpressOrderVO;
import client.vo.LoadOrderVO;

public class LoadOrderService_stub implements LoadOrderService {

	private LoadOrderDataService_stub datastub;

	public LoadOrderService_stub() {
		datastub = new LoadOrderDataService_stub();
	}

	@Override
	public LoadOrderVO create(List<ExpressOrderVO> orders, LoadOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return orderinfo;
	}

	@Override
	public ResultMessage save(LoadOrderVO order) {
		// TODO 自动生成的方法存根
		return datastub.add(getPO(order));
	}

	@Override
	public LoadOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(id));
	}

	private LoadOrderPO getPO(LoadOrderVO vo) {
		return new LoadOrderPO();
	}

	private LoadOrderVO getVO(LoadOrderPO po) {
		return new LoadOrderVO();
	}

}
