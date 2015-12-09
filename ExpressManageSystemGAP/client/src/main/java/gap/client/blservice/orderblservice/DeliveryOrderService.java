package gap.client.blservice.orderblservice;

import gap.client.vo.DeliveryOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface DeliveryOrderService {

	public ResultMessage save(DeliveryOrderVO order);

}
