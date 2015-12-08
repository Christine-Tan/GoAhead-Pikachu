package gap.client.ui.AccountUI;

import java.util.ArrayList;
import java.util.Iterator;

import gap.client.bl.account.AccountBlController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.vo.AccountVO;

public class AccountPanel extends MainPanel{

	AccountBlController accountBlController;
	ArrayList<AccountVO> accounts;
	
	public AccountPanel(MainFrame frame) {
		super(frame);
	}
	
	public void initial(){
		accountBlController = AccountBlController.getInstance();
		Iterator<AccountVO> itr = accountBlController.getAccountManageList();
		itrToList(itr);
		
		
		
		
	}
	
	//迭代器内容存入accounts
	private void itrToList(Iterator<AccountVO> itr){
		if(accounts==null){
			accounts = new ArrayList<>(30);
		}
		accounts.clear();
		while(itr.hasNext()){
			accounts.add(itr.next());
		}
		
	}

}
