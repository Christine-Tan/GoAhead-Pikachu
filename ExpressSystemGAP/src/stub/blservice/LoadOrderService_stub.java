package stub.blservice;

import java.util.List;

import po.ResultMessage;
import client.blservice.orderblservice.LoadOrderService;
import client.vo.ExpressOrderVO;
import client.vo.LoadOrderVO;

public class LoadOrderService_stub implements LoadOrderService{

	@Override
	public LoadOrderVO create(List<ExpressOrderVO> orders, LoadOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(LoadOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LoadOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
