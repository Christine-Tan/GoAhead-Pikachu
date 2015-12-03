package gap.client.blservice.orderblservice;

import gap.client.vo.BillVO;
import gap.common.po.BillOrderPO;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface BillOrderService {
	public List<BillVO> getPreviewBills(String date);

	public ResultMessage save(BillOrderPO billorder);

	List<UserPO> getDelivery();

}
