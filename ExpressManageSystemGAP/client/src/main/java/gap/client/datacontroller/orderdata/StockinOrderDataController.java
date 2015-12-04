package gap.client.datacontroller.orderdata;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.StockinOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class StockinOrderDataController {
	StockinOrderDataService stockinOrder;

	public StockinOrderDataController() {
		try {
			stockinOrder = (StockinOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.STOCKINORDER_DATA_SERVICE);
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

	public ResultMessage add(StockinOrderPO po) {
		// TODO Auto-generated method stub
		try {
			return stockinOrder.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public StockinOrderPO find(String order_id, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockinOrder.find(order_id, ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockinOrderPO> getOneDay(String date, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockinOrder.getOneDay(date, ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockinOrderPO> getRequired(String beginDate, String endDate,
			String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockinOrder.getRequired(beginDate, endDate, ins_id);
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
	 * public List<StockinOrderPO> getUnpassedOrders(){ // TODO Auto-generated
	 * method stub return null; }
	 */

}
