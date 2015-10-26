package dataservice.accountdataservice;

import java.awt.List;
import java.util.ArrayList;

import po.AccountPO;
import po.Cost_profitPO;
import po.TradePO;

public interface AccountDataService {

	public boolean add(AccountPO accountPO);
	public boolean delete(AccountPO accountPO);
	public boolean modify(AccountPO accountPO);
	public boolean trade(TradePO tradePO);
	public ArrayList<Cost_profitPO> getCost_Profit();
	public ArrayList<AccountPO> getAccountList();
	
}
