package gap.client.blservice.orderblservice;

import gap.client.vo.LoadOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface LoadOrderService {
	public LoadOrderVO create(List<String> orders,
			LoadOrderVO orderinfo);

	public ResultMessage save(LoadOrderVO order);

	public LoadOrderVO find(String id);
}
