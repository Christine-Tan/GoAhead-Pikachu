package gap.client.datacontroller.ApprovalDataStrategy;

import gap.client.datacontroller.AppDataStrategyFactory;
import gap.client.datacontroller.ApprovalDataController;
import gap.common.App;
import gap.common.ListInterface.Order;
import gap.common.util.ResultMessage;

public abstract class AppStrategy {

	AppDataStrategyFactory factory;
	public AppStrategy(AppDataStrategyFactory factory){
		this.factory = factory;
	}
	public abstract ResultMessage setPassed(Order order);
}
