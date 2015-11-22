package gap.server.data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import com.mysql.jdbc.BalanceStrategy;

import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.po.AccountPO;
import gap.common.po.Cost_profitPO;
import gap.common.po.TradePO;
import gap.server.databaseutility.Excutor;

public class AccountDataServiceImpl implements AccountDataService{

	String name= "Name";
	String balance = "Baleance";
	String income="Income";
	String pay="Pay";
	Excutor excutor = Excutor.getInstance();
	@Override
	public boolean add(AccountPO accountPO) throws RemoteException {
		// TODO Auto-generated method stub
		String name = accountPO.getName();
		StringBuilder builder = new StringBuilder("Insert into ");
		
		
		return true;
	}

	@Override
	public boolean delete(AccountPO accountPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(AccountPO accountPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean trade(TradePO tradePO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cost_profitPO> getCost_Profit() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountPO> getAccountList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
