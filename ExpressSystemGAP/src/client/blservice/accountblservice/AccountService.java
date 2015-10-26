package client.blservice.accountblservice;

import client.vo.AccountListVO;
import util.ResultMessage;

public interface AccountService {
	
	public AccountListVO getAccountManageList();
	public ResultMessage setAccountManageList(AccountListVO accountListVO);
	
	
}
