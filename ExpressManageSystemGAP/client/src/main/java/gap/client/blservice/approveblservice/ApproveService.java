package gap.client.blservice.approveblservice;

import gap.common.po.SuperOrderPO;
import gap.common.util.ResultMessage;

public interface ApproveService {
            public SuperOrderPO getSuperOrder(String type);
            
            public ResultMessage approve(SuperOrderPO po);
}
