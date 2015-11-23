package gap.common.dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.PricePO;
import gap.common.util.ResultMessage;

public interface PriceDataService extends Remote {
	public PricePO find(String city_id) throws RemoteException;

	public ResultMessage add(PricePO po) throws RemoteException;

	public ResultMessage modify(PricePO po) throws RemoteException;

	public List<PricePO> getAll() throws RemoteException;
}
