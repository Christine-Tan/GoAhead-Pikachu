package gap.client.blservice.accountblservice;

import gap.client.vo.AccountListVO;
import gap.common.util.ResultMessage;

public interface AccountService {
	
	public AccountListVO getAccountManageList();
	public ResultMessage setAccountManageList(AccountListVO accountListVO);
	
	
}
