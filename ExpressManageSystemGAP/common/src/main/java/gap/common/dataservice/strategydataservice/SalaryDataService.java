package gap.common.dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.SalaryPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

public interface SalaryDataService extends Remote {
	public SalaryPO find(UserType type) throws RemoteException;

	public ResultMessage add(SalaryPO po) throws RemoteException;

	public ResultMessage modify(SalaryPO po) throws RemoteException;
}
