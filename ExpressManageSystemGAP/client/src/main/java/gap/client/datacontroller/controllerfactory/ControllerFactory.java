package gap.client.datacontroller.controllerfactory;

import gap.client.datacontroller.expressorderdata.ExpressOrderDataController;
import gap.client.datacontroller.inventorydata.InventoryDataController;
import gap.client.datacontroller.logindata.LoginDataController;
import gap.client.datacontroller.transdata.TransDataController;
import gap.client.util.LocalInfo;
import gap.common.util.UserType;

public class ControllerFactory {
	private static LoginDataController loginDataController;

	public static LoginDataController getLoginDataController() {
		if (loginDataController == null)
			loginDataController = new LoginDataController();
		return loginDataController;
	}

	public static ExpressOrderDataController getExpressOrderDataController() {
		return null;
	}

	public static TransDataController getTransDataController() {
		return null;
	}
	
	public static InventoryDataController getInventoryDataController(){
		return null;
	}

}
