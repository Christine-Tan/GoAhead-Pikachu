package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.approval.Approval;
import gap.common.util.ResultMessage;

public class ApprovalController {
    private static Approval approvalManage=new Approval();
	public ApprovalController() {
		// TODO Auto-generated constructor stub
	}
    
	public static List<Object> getUnpassedOrder(){
		return approvalManage.getUnpassedOrder();
	}
	
	public static  ResultMessage approve(){
		return approvalManage.approve();
	}
	
}
