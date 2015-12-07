package gap.client.datacontroller;

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
import static gap.client.datacontroller.NetModule.stockinorderdataservice;
public class StockinOrderDataController {

	protected StockinOrderDataController() {
	}

	public ResultMessage add(StockinOrderPO po) {
		// TODO Auto-generated method stub
		try {
			return stockinorderdataservice.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public StockinOrderPO find(String order_id, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockinorderdataservice.find(order_id, ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockinOrderPO> getOneDay(String date, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return stockinorderdataservice.getOneDay(date, ins_id);
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
			return stockinorderdataservice.getRequired(beginDate, endDate, ins_id);
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
