package gap.common.dataservice.userdataservice;

import gap.common.po.UserPO;
import gap.common.util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserDataService extends Remote {
	public List<UserPO> getAll() throws RemoteException;

	public ResultMessage add(UserPO po) throws RemoteException;

	public UserPO find(String user_id) throws RemoteException;

	public ResultMessage modify(UserPO po) throws RemoteException;

	public ResultMessage delete(String user_id) throws RemoteException;

}
