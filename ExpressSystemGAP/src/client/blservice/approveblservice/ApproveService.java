package client.blservice.approveblservice;

import po.SuperOrderPO;
import util.ResultMessage;

public interface ApproveService {
            public SuperOrderPO getSuperOrder(String type);
            
            public ResultMessage approve(SuperOrderPO po);
}
