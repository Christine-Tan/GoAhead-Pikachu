package stub_drivers.blservice.account;import com.mysql.jdbc.Driver;

import client.blservice.accountblservice.AccountService;
import client.vo.AccountListVO;

public class accountbl_driver {
	public void drive(AccountService stub) {
		AccountListVO accountListVO = stub.getAccountManageList();
		System.out.println(stub.setAccountManageList(accountListVO));
	}
	
	public static void main(String[] args) {
		new accountbl_driver().drive(new accountbl_stub());
	}
	
}
