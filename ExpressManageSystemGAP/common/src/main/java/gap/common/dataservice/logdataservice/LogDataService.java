package gap.common.dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.LogPO;

public interface LogDataService extends Remote {

	public LogPO getLogList() throws RemoteException;

	public Boolean addLog(LogPO logPO) throws RemoteException;

}
