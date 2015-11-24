package gap.server.data.strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.po.InstitutionPO;
import gap.common.po.SalaryPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

/**
 * @author seven
 */
public class SalaryDataServiceImpl extends UnicastRemoteObject implements SalaryDataService{
   //表名
	String tablename="salary";
	//字段
	public SalaryDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public SalaryPO find(UserType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
   
}
