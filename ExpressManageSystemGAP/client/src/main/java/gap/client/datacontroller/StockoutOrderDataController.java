package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.StockoutOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import static gap.client.datacontroller.NetModule.stockoutorderdataservice;

public class StockoutOrderDataController {

	protected StockoutOrderDataController() {
	}

	public ResultMessage add(StockoutOrderPO po) {
		// TODO Auto-generated method stub
		try {
			return stockoutorderdataservice.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public StockoutOrderPO find(String order_id, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockoutorderdataservice.find(order_id, ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockoutOrderPO> getOneDay(String date, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockoutorderdataservice.getOneDay(date, ins_id);
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
			return stockoutorderdataservice.getRequired(beginDate, endDate,
					ins_id);
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
