package client.blservice.orderblservice;

import java.util.List;



import util.ResultMessage;
import client.vo.LoadOrderVO;
import client.vo.ExpressOrderVO;

public interface LoadOrderService {
	public LoadOrderVO create(List<String> orders,
			LoadOrderVO orderinfo);

	public ResultMessage save(LoadOrderVO order);

	public LoadOrderVO find(String id);
}
