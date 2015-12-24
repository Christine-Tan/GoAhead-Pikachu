package gap.server.data.initial;

import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.initialdata.InitialDataService;
import gap.common.po.InitialHistoryPO;


public class InitialDataServiceImpl implements InitialDataService{

	private static InitialDataServiceImpl initialDataServiceImpl;
	
	public InitialDataService getInstance(){
		if(initialDataServiceImpl==null){
			initialDataServiceImpl = new InitialDataServiceImpl();
		}
		return initialDataServiceImpl;
	}
	
	@Override
	public boolean addInitial(InitialHistoryPO initialPO) throws RemoteException {
		
		return false;
	}

	@Override
	public List<InitialHistoryPO> getHistory() throws RemoteException {
	
		return null;
	}


}
