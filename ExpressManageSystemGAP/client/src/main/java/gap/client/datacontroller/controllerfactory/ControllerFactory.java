package gap.client.datacontroller.controllerfactory;

import gap.client.datacontroller.expressorderdata.ExpressOrderDataController;
import gap.client.datacontroller.inventorydata.InventoryDataController;
import gap.client.datacontroller.logindata.LoginDataController;
import gap.client.datacontroller.orderdata.ArrivedOrderDataController;
import gap.client.datacontroller.orderdata.BillOrderDateController;
import gap.client.datacontroller.orderdata.DeliveryOrderDataController;
import gap.client.datacontroller.orderdata.LoadOrderDataController;
import gap.client.datacontroller.orderdata.StockinOrderDataController;
import gap.client.datacontroller.orderdata.StockoutOrderDataController;
import gap.client.datacontroller.transdata.TransDataController;
import gap.client.util.LocalInfo;
import gap.common.util.UserType;

public class ControllerFactory {
	private static LoginDataController loginDataController;
	private static ExpressOrderDataController expressOrderDataController;
	private static LoadOrderDataController loadorderdatacontroller;
	private static ArrivedOrderDataController arrivedorderdatacontroller;
	private static DeliveryOrderDataController deliveryorderdatacontroller;
	private static InventoryDataController inventoryDataController;
	private static StockinOrderDataController stockinOrderDataController;
	private static StockoutOrderDataController stockoutOrderDataController;
	private static BillOrderDateController billorderdatacontroller;
	private static TransDataController transdatacontroller;

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
		if (transdatacontroller == null)
			transdatacontroller = new TransDataController();
		return transdatacontroller;
	}

	public static InventoryDataController getInventoryDataController() {
		if (inventoryDataController == null)
			inventoryDataController = new InventoryDataController();
		return inventoryDataController;
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

	public static BillOrderDateController getBillOrderDateController() {
		if (billorderdatacontroller == null)
			billorderdatacontroller = new BillOrderDateController();
		return billorderdatacontroller;
	}

	public static DeliveryOrderDataController getDeliveryOrderDataController() {
		if (deliveryorderdatacontroller == null)
			deliveryorderdatacontroller = new DeliveryOrderDataController();
		return deliveryorderdatacontroller;
	}

	public static StockinOrderDataController getStockinOrderDataController() {
		if (stockinOrderDataController == null)
			stockinOrderDataController = new StockinOrderDataController();
		return stockinOrderDataController;
	}

	public static StockoutOrderDataController getStockoutOrderDataController() {
		if (stockoutOrderDataController == null)
			stockoutOrderDataController = new StockoutOrderDataController();
		return stockoutOrderDataController;
	}

}
