package dataservice.accountdataservice;

import java.awt.List;

public interface AccountDataService {

	public boolean add(AccountPO accountPO);
	public boolean delete(AccountPO accountPO);
	public boolean modify(AccountPO accountPO);
	public boolean trade(TradePO tradePO);
	public List<Cost_profitPO> getCost_Profit();
	public List<AccountPO> getAccountList();
	
}
