package gap.client.blservice.approvalblservice;

import gap.common.po.SuperOrderPO;
import gap.common.util.ResultMessage;

public interface ApprovalService {
            public SuperOrderPO getSuperOrder(String type);
            
            public ResultMessage approve(SuperOrderPO po);
}
