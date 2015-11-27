package gap.client.bl.account;

import java.util.ArrayList;

import gap.client.util.SearchResult;
import gap.client.vo.AccountVO;

public class AccountSearcher {
	ArrayList<AccountVO> originalList;
	public AccountSearcher(ArrayList<AccountVO> originalList){
		this.originalList = originalList;
	}
	
	public ArrayList<SearchResult> search(String keyword){
		
	}
	
}
