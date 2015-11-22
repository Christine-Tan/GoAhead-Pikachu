package gap.server.data.strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.util.ResultMessage;

public class RentDataServiceImpl extends UnicastRemoteObject implements RentDataService{

	public RentDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double modifyRent(double rent) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRent() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
