package gap.client.bl.order;

import java.util.List;

import gap.client.blservice.orderblservice.LoadOrderService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.orderdata.LoadOrderDataController;
import gap.client.vo.LoadOrderVO;
import gap.common.util.ResultMessage;

public class LoadOrder implements LoadOrderService {
	LoadOrderDataController loadDataController;

	public LoadOrder() {
		loadDataController = ControllerFactory.getLoadOrderDataController();
	}

	@Override
	public LoadOrderVO create(List<String> orders, LoadOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(LoadOrderVO order) {
		// TODO 自动生成的方法存根
		return loadDataController.add(order.toPO());
	}

	@Override
	public LoadOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
