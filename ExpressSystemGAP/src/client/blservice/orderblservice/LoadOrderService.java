package client.blservice.orderblservice;

import java.util.List;

import po.ResultMessage;
import client.vo.LoadOrderVO;
import client.vo.ExpressOrderVO;

public interface LoadOrderService {
	public LoadOrderVO create(List<ExpressOrderVO> orders,
			LoadOrderVO orderinfo);

	public ResultMessage save(LoadOrderVO order);

	public LoadOrderVO find(String id);
}
