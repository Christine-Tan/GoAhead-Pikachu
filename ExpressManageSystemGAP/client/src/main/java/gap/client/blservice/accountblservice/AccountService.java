package gap.client.blservice.accountblservice;

import java.util.ArrayList;
import java.util.Iterator;

import gap.client.util.SearchResult;
import gap.client.vo.AccountVO;
import gap.common.util.ResultMessage;

public interface AccountService {
	
	public Iterator<AccountVO> getAccountManageList();
	public ResultMessage addAccount(AccountVO vo);
	public ResultMessage deleteAccount(AccountVO vo);
	public ResultMessage modifyAccount(AccountVO vo);
	public ArrayList<SearchResult> searchAccount(String keyword);
	public ResultMessage confirm();
	
	
	
}
