package gap.common.dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import gap.common.po.RentPO;
import gap.common.util.ResultMessage;

public interface RentDataService extends Remote {

	public List<RentPO> getAll() throws RemoteException;

	public ResultMessage add(RentPO po) throws RemoteException;

	public ResultMessage update(RentPO po) throws RemoteException;
	
	public ResultMessage setPaid(String institution)throws RemoteException;
}
