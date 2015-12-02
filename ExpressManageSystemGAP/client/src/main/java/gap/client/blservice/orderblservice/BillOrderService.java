package gap.client.blservice.orderblservice;

import gap.common.po.BillOrderPO;
import gap.common.po.BillPO;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface BillOrderService {
	public List<BillPO> getPreviewBills(List<String> delivery_ids, String date);

	public ResultMessage save(BillOrderPO billorder);

	public List<UserPO> getDelivery();

}
