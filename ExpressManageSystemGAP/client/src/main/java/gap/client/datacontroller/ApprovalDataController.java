package gap.client.datacontroller;

/**
 * @author seven
 */
import gap.client.vo.ArrivedOrderVO;
import gap.client.vo.BillOrderVO;
import gap.client.vo.DeliveryOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.LoadOrderVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.dataservice.ServiceName;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.dataservice.receiptdataservice.BillOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.BillOrderPO;
import gap.common.po.DeliveryOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.po.LoadOrderPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ApprovalDataController {
	ExpressOrderDataService expressOrderData;
	ArrivedOrderDataService arrivedOrderData;
	BillOrderDataService billOrderData;
	DeliveryOrderDataService deliveryOrderData;
	LoadOrderDataService loadOrderData;
	StockinOrderDataService stockinOrderData;
	StockoutOrderDataService stockoutOrderData;
	InstitutionDataService institutionData;

	protected ApprovalDataController() {
		try {
			expressOrderData = (ExpressOrderDataService) Naming
					.lookup(RMIConfig.url + ServiceName.EXPRESSORDER_DATA_SERVICE);
			arrivedOrderData = (ArrivedOrderDataService) Naming
					.lookup(RMIConfig.url + ServiceName.ARRIVEDORDER_DATA_SERVICE);
			billOrderData = (BillOrderDataService) Naming.lookup(RMIConfig.url + ServiceName.BILLORDER_DATA_SERVICE);
			deliveryOrderData = (DeliveryOrderDataService) Naming
					.lookup(RMIConfig.url + ServiceName.DELIVERYPORDER_DATA_SERVICE);
			loadOrderData = (LoadOrderDataService) Naming.lookup(RMIConfig.url + ServiceName.LOADORDER_DATA_SERVICE);
			stockinOrderData = (StockinOrderDataService) Naming
					.lookup(RMIConfig.url + ServiceName.STOCKINORDER_DATA_SERVICE);
			stockoutOrderData = (StockoutOrderDataService) Naming
					.lookup(RMIConfig.url + ServiceName.STOCKOUTORDER_DATA_SERVICE);
			institutionData = (InstitutionDataService) Naming
					.lookup(RMIConfig.url + ServiceName.INSTITUTION_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ExpressOrderPO> getUnpassedExpressOrder() {
		try {
			return expressOrderData.getUnpassedOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ArrivedOrderPO> getUnpassedArrivedOrder() {
		try {
			return arrivedOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BillOrderPO> getUnpassedBillOrder() {
		try {
			return billOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<DeliveryOrderPO> getUnpassedDeliveryOrder() {
		try {
			return deliveryOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<LoadOrderPO> getUnpassedLoadOrder() {
		try {
			return loadOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockinOrderPO> getUnpassedStockinOrder() {
		try {
			return stockinOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockoutOrderPO> getUnpassedStockoutOrder() {
		try {
			return stockoutOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage setPassed(List<Object> orders) {
		ResultMessage rm;
		for (Object order : orders) {
			if (order instanceof ExpressOrderVO) {
				String targetInsId = ((ExpressOrderVO) order).targetins_id;
				try {
					String insname = institutionData.findById(targetInsId).getInsName();
					String state = insname + "已收件";
					rm = expressOrderData.setPassed(((ExpressOrderVO) order).order_id, state);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (order instanceof ArrivedOrderVO) {
				String targetInsId = ((ArrivedOrderVO) order).des_ins_id;
				try {
					String insname = institutionData.findById(targetInsId).getInsName();
					String state = insname + "已收件";
					rm = arrivedOrderData.setPassed(((ArrivedOrderVO) order).id, state);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof BillOrderVO) {
				// rm=billOrderData.setPassed(, state_info)
			} else if (order instanceof DeliveryOrderVO) {
				try {
					rm = deliveryOrderData.setPassed(((DeliveryOrderVO) order).id, "");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (order instanceof LoadOrderVO) {
				String targetInsId = ((LoadOrderVO) order).getTargetins_id();
				try {
					String insname = institutionData.findById(targetInsId).getInsName();
					String state = "正在发往" + insname;
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (order instanceof StockinOrderVO) {

			} else if (order instanceof StockoutOrderVO) {

			}
		}
		return ResultMessage.FAILED;
	}
}
