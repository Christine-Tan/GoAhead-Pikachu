package gap.client.datacontroller.approvaldata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.orderdataservice.BillOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.BillOrderPO;
import gap.common.po.DeliveryOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.po.LoadOrderPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;

public class ApprovalDataController {
      ExpressOrderDataService expressOrderData;
      ArrivedOrderDataService arrivedOrderData;
      BillOrderDataService billOrderData;
      DeliveryOrderDataService deliveryOrderData;
      LoadOrderDataService loadOrderData;
      StockinOrderDataService stockinOrderData;
      StockoutOrderDataService stockoutOrderData;
      
      public ApprovalDataController(){
    	  try {
			expressOrderData=(ExpressOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.EXPRESSORDER_DATA_SERVICE);
			arrivedOrderData= (ArrivedOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.ARRIVEDORDER_DATA_SERVICE);
			billOrderData= (BillOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.BILLORDER_DATA_SERVICE);
			deliveryOrderData= (DeliveryOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.DELIVERYPORDER_DATA_SERVICE);
			loadOrderData= (LoadOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.LOADORDER_DATA_SERVICE);
			stockinOrderData= (StockinOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.STOCKINORDER_DATA_SERVICE);
			stockoutOrderData= (StockoutOrderDataService) Naming.lookup(RMIConfig.url+ServiceName.STOCKOUTORDER_DATA_SERVICE);
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
      
      public List<ExpressOrderPO> getUnpassedExpressOrder(){
    	  try {
			return expressOrderData.getUnpassedOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
      public List<ArrivedOrderPO> getUnpassedArrivedOrder(){
    	  try {
			return arrivedOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
      public List<BillOrderPO> getUnpassedBillOrder(){
    	  try {
			return billOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
      public List<DeliveryOrderPO> getUnpassedDeliveryOrder(){
    	  try {
			return deliveryOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
      public List<LoadOrderPO> getUnpassedLoadOrder(){
    	  try {
			return loadOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
      public List<StockinOrderPO> getUnpassedStockinOrder(){
    	  try {
			return stockinOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
      public List<StockoutOrderPO> getUnpassedStockoutOrder(){
    	  try {
			return stockoutOrderData.getUnpassedOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
      }
      
//      public ResultMessage setPassed(List<>)
}

