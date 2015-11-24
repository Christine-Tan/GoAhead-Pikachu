package gap.common.dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import gap.common.po.RentPO;

public interface RentDataService extends Remote {
	
	public List<RentPO> getAll() throws RemoteException;
	
}
