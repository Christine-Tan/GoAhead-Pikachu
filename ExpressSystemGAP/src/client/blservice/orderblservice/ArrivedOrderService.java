package client.blservice.orderblservice;

import java.util.List;



import util.ResultMessage;
import client.vo.ArrivedOrderVO;
import client.vo.ExpressOrderVO;

public interface ArrivedOrderService {
	public ArrivedOrderVO create(List<ExpressOrderVO> orders,
			ArrivedOrderVO orderinfo);

	public ResultMessage save(ArrivedOrderVO order);

	public ArrivedOrderVO find(String id);

}
