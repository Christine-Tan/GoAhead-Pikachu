package gap.client.datacontroller;

import static gap.client.datacontroller.NetModule.logdataservice;

import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.LogPO;

public class LogDataController {
	protected LogDataController(){
	}
	
	public List<LogPO> getLogList(){
		try {
			List<LogPO> logPOs = logdataservice.getLogList();
			return logPOs;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
