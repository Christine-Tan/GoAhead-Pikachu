package gap.client.datacontroller.controllerfactory;

import gap.client.datacontroller.expressorderdata.ExpressOrderDataController;
import gap.client.datacontroller.inventorydata.InventoryDataController;
import gap.client.datacontroller.logindata.LoginDataController;
import gap.client.datacontroller.orderdata.ArrivedOrderDataController;
import gap.client.datacontroller.orderdata.DeliveryOrderDataController;
import gap.client.datacontroller.orderdata.LoadOrderDataController;
import gap.client.datacontroller.transdata.TransDataController;
import gap.client.util.LocalInfo;
import gap.common.util.UserType;

public class ControllerFactory {
	private static LoginDataController loginDataController;
	private static ExpressOrderDataController expressOrderDataController;
	private static LoadOrderDataController loadorderdatacontroller;
	private static ArrivedOrderDataController arrivedorderdatacontroller;
	private static DeliveryOrderDataController deliveryorderdatacontroller;

	public static LoginDataController getLoginDataController() {
		if (loginDataController == null)
			loginDataController = new LoginDataController();
		return loginDataController;
	}

	public static ExpressOrderDataController getExpressOrderDataController() {
		if (expressOrderDataController == null)
			expressOrderDataController = new ExpressOrderDataController();
		return expressOrderDataController;
	}

	public static TransDataController getTransDataController() {
		return null;
	}

	public static InventoryDataController getInventoryDataController() {
		return null;
	}

	public static LoadOrderDataController getLoadOrderDataController() {
		if (loadorderdatacontroller == null)
			loadorderdatacontroller = new LoadOrderDataController();
		return loadorderdatacontroller;
	}

	public static ArrivedOrderDataController getArrivedOrderDataController() {
		if (arrivedorderdatacontroller == null)
			arrivedorderdatacontroller = new ArrivedOrderDataController();
		return arrivedorderdatacontroller;
	}

	public static DeliveryOrderDataController getDeliveryOrderDataController() {
		if (deliveryorderdatacontroller == null)
			deliveryorderdatacontroller = new DeliveryOrderDataController();
		return deliveryorderdatacontroller;
	}

}
