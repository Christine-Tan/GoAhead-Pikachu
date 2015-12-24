package gap.common.dataservice.initialdata;

import gap.common.po.InitialHistoryPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InitialDataService extends Remote {

	public boolean addInitial(InitialHistoryPO initialPO) throws RemoteException;

	public List<InitialHistoryPO> getHistory() throws RemoteException;

}
