package gap.client.bl.order;

import gap.client.blservice.orderblservice.LoadOrderService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.LoadOrderDataController;
import gap.client.util.LocalInfo;
import gap.client.vo.LoadOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

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
		// String pre=LocalInfo.ins_id+order.
		String date = order.date.replaceAll("-", "");
		String pre = LocalInfo.ins_id + date;
		String id = "" + loadDataController.nextId(LocalInfo.ins_id + date);
		while (id.length() < 5)
			id = "0" + id;
		order.order_id = pre + id;
		return loadDataController.add(order.toPO());
	}

	@Override
	public LoadOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
