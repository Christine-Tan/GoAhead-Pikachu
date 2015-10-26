package stub_drivers.blservice.account;

import client.blservice.accountblservice.AccountService;
import client.vo.AccountListVO;
import util.ResultMessage;

public class accountbl_stub implements AccountService {

	@Override
	public AccountListVO getAccountManageList() {
		// TODO Auto-generated method stub
		return new AccountListVO();
	
	}

	@Override
	public ResultMessage setAccountManageList(AccountListVO accountListVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

}
