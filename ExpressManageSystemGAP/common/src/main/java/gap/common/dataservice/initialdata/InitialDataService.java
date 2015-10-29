package gap.common.dataservice.initialdata;

import gap.common.po.InitialPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InitialDataService extends Remote {

	public boolean addInitial(InitialPO initialPO) throws RemoteException;

	public List<InitialPO> getHistory() throws RemoteException;

}
