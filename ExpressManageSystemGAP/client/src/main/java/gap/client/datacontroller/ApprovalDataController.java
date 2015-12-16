package gap.client.datacontroller;

/**
 * @author seven
 */
import static gap.client.datacontroller.NetModule.arrivedOrderdataservice;
import static gap.client.datacontroller.NetModule.billorderdataservice;
import static gap.client.datacontroller.NetModule.deliveryorderdataservice;
import static gap.client.datacontroller.NetModule.expressorderdataservice;
import static gap.client.datacontroller.NetModule.institutiondataservice;
import static gap.client.datacontroller.NetModule.loadorderdataservice;
import static gap.client.datacontroller.NetModule.stockinorderdataservice;
import static gap.client.datacontroller.NetModule.stockoutorderdataservice;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.BillOrderPO;
import gap.common.po.DeliveryOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.po.LoadOrderPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public class ApprovalDataController {

	protected ApprovalDataController() {

	}

	public List<ExpressOrderPO> getUnpassedExpressOrder() {
		try {
			return expressorderdataservice.getUnpassedOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ArrivedOrderPO> getUnpassedArrivedOrder() {
		try {
			return arrivedOrderdataservice.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BillOrderPO> getUnpassedBillOrder() {
		try {
			return billorderdataservice.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<DeliveryOrderPO> getUnpassedDeliveryOrder() {
		try {
			return deliveryorderdataservice.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<LoadOrderPO> getUnpassedLoadOrder() {
		try {
			return loadorderdataservice.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockinOrderPO> getUnpassedStockinOrder() {
		try {
			return stockinorderdataservice.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockoutOrderPO> getUnpassedStockoutOrder() {
		try {
			return stockoutorderdataservice.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage setPassed(List<Object> orders) {
		ResultMessage rm;
		for (Object order : orders) {
			if (order instanceof ExpressOrderPO) {
				String targetInsId = ((ExpressOrderPO) order).getTargetins_id();
				try {
					String insname = institutiondataservice.findById(targetInsId).getInsName();
					String state = insname + "已收件";
					rm = expressorderdataservice.setPassed(((ExpressOrderPO) order).getOrder_id(), state);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (order instanceof ArrivedOrderPO) {
				String targetInsId = ((ArrivedOrderPO) order).getDes_ins_id();
				try {
					String insname = institutiondataservice.findById(targetInsId).getInsName();
					String state = insname + "已收件";
					rm = arrivedOrderdataservice.setPassed(((ArrivedOrderPO) order).getId(), state);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof BillOrderPO) {
				try {
					rm = billorderdataservice.setPassed(((BillOrderPO) order).getId(), "");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof DeliveryOrderPO) {
				try {
					rm = deliveryorderdataservice.setPassed(((DeliveryOrderPO) order).getId(), "");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof LoadOrderPO) {
				String targetInsId = ((LoadOrderPO) order).getTargetins_id();
				try {
					String insname = institutiondataservice.findById(targetInsId).getInsName();
					String state = "正在发往" + insname;
					rm = loadorderdataservice.setPassed(((LoadOrderPO) order).getOrder_id(), state);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof StockinOrderPO) {
				try {
					rm = stockinorderdataservice.setPassed(((StockinOrderPO) order).getId(), "");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof StockoutOrderPO) {
				try {
					rm = stockoutorderdataservice.setPassed(((StockoutOrderPO) order).getId(), "");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ResultMessage.FAILED;
	}
}
