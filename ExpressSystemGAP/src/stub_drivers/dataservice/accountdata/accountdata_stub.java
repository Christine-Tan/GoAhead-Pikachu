package stub_drivers.dataservice.accountdata;

import java.util.ArrayList;

import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import po.Cost_profitPO;
import po.TradePO;

public class accountdata_stub implements AccountDataService {

	@Override
	public boolean add(AccountPO accountPO) {
		// TODO Auto-generated method stub
		System.out.println("added "+accountPO.getName());
		
		return true;
	}

	@Override
	public boolean delete(AccountPO accountPO) {
		// TODO Auto-generated method stub
		
		System.out.println("deleted "+accountPO.getName());
		
		return true;
	}

	@Override
	public boolean modify(AccountPO accountPO) {
		// TODO Auto-generated method stub
		System.out.println("modified "+accountPO.getName()+" from "+100
			+" to "+accountPO.getBalance());
		
		return true;
	}

	@Override
	public boolean trade(TradePO tradePO) {
		// TODO Auto-generated method stub
		if(tradePO.getTradeNum()<0){
			int a = -tradePO.getTradeNum();
			System.out.println("payed "+a+"yuan" );
		}else{
			
			System.out.println("payed "+tradePO.getTradeNum()+"yuan" );
		}
		
		
		return true;
	}

	@Override
	public ArrayList<Cost_profitPO> getCost_Profit() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public ArrayList<AccountPO> getAccountList() {
		// TODO Auto-generated method stub
		return new ArrayList<AccountPO>();
	}

}
