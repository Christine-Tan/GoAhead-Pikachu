package gap.client.blservice.approvalblservice;

import java.util.List;

import gap.common.util.ResultMessage;

public interface ApprovalService {
            public List<Object> getUnpassedOrder();
            
            public ResultMessage approve(List<Object> orders);
}
