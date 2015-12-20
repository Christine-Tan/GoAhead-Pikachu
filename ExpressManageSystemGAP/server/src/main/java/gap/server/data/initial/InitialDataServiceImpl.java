package gap.server.data.initial;

import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.initialdata.InitialDataService;
import gap.common.po.InitialPO;

public class InitialDataServiceImpl implements InitialDataService{

	@Override
	public boolean addInitial(InitialPO initialPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<InitialPO> getHistory() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
