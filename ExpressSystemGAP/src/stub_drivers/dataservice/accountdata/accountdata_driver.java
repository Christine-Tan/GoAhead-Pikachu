package stub_drivers.dataservice.accountdata;

import client.vo.AccountListVO;
import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import po.TradePO;
import stub_drivers.blservice.account.accountbl_stub;

public class accountdata_driver {
	
	public void drive(AccountDataService stub){
		stub.getAccountList();
		stub.add(new AccountPO("master", 1000));
		stub.trade(new TradePO("aaa", 20));
		
	}
	
	public static void main(String[] args) {
		new accountdata_driver().drive(new accountdata_stub());	
	}
}
