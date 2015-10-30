package gap.common.dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RentDataService extends Remote {
	public double modifyRent(double rent) throws RemoteException;

	public double getRent() throws RemoteException;
}
