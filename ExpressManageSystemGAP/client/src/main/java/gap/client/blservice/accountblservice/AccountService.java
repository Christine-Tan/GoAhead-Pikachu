package gap.client.blservice.accountblservice;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import gap.client.vo.AccountVO;
import gap.common.util.ResultMessage;

public interface AccountService {
	
	public ArrayList<AccountVO> getAccountManageList();
	public ResultMessage addAccount(AccountVO vo);
	public ResultMessage deleteAccount(AccountVO vo);
	public ResultMessage modifyAccount(AccountVO vo);
	public ArrayList<AccountVO> searchAccount(String keyword);
	public ResultMessage confirm();
	
	
	
}
