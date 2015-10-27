package gap.common.dataservice.accountdataservice;

import gap.common.po.AccountPO;
import gap.common.po.Cost_profitPO;
import gap.common.po.TradePO;

import java.awt.List;
import java.util.ArrayList;

public interface AccountDataService {

	public boolean add(AccountPO accountPO);

	public boolean delete(AccountPO accountPO);

	public boolean modify(AccountPO accountPO);

	public boolean trade(TradePO tradePO);

	public ArrayList<Cost_profitPO> getCost_Profit();

	public ArrayList<AccountPO> getAccountList();

}
