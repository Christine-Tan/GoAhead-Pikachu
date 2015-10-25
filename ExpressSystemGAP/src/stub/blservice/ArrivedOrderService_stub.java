package stub.blservice;

import java.util.List;


import util.ResultMessage;
import client.blservice.orderblservice.ArrivedOrderService;
import client.vo.ArrivedOrderVO;
import client.vo.ExpressOrderVO;

public class ArrivedOrderService_stub implements ArrivedOrderService{

	@Override
	public ArrivedOrderVO create(List<ExpressOrderVO> orders,
			ArrivedOrderVO orderinfo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(ArrivedOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrivedOrderVO find(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
