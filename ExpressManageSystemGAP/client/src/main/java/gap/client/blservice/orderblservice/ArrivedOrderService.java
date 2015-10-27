package gap.client.blservice.orderblservice;

import gap.client.vo.ArrivedOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface ArrivedOrderService {
	public ArrivedOrderVO create(List<ExpressOrderVO> orders,
			ArrivedOrderVO orderinfo);

	public ResultMessage save(ArrivedOrderVO order);

	public ArrivedOrderVO find(String id);

}
