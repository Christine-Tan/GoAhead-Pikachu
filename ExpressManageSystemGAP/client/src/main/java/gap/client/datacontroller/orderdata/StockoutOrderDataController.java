package gap.client.datacontroller.orderdata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

public class StockoutOrderDataController {
	StockoutOrderDataService stockoutOrder;

	public StockoutOrderDataController() {
		try {
			stockoutOrder = (StockoutOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.STOCKOUTORDER_DATA_SERVICE);
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

	public ResultMessage add(StockoutOrderPO po) {
		// TODO Auto-generated method stub
		try {
			return stockoutOrder.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public StockoutOrderPO find(String order_id) {
		// TODO Auto-generated method stub
		try {
			return stockoutOrder.find(order_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockoutOrderPO> getOneDay(String date, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockoutOrder.getOneDay(date, ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockoutOrderPO> getRequired(String beginDate, String endDate,
			String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockoutOrder.getRequired(beginDate, endDate, ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public ResultMessage setPassed(String order_id, String state_info) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * 
	 * public List<StockoutOrderPO> getUnpassedOrders() { // TODO Auto-generated
	 * method stub return null; }
	 */
}
