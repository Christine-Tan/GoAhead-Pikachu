package gap.client.bl.account;

import java.util.ArrayList;
import java.util.Iterator;

import gap.client.blservice.accountblservice.AccountService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.AccountDate.AccountDateController;
import gap.client.util.SearchResult;
import gap.client.vo.AccountVO;
import gap.common.po.AccountPO;
import gap.common.util.ResultMessage;

public class AccountBlController implements AccountService{

	AccountCmdBuffer buffer;
	ArrayList<AccountVO> accounts;
	private static AccountBlController controller=null;
	private AccountDateController dateController;
	private AccountBlController() {
		buffer = new AccountCmdBuffer();
		dateController = ControllerFactory.getAccountDataController();
	}
	
	public static AccountBlController getInstance(){
		
		if(controller==null){
			controller = new AccountBlController();
		}
		return controller;
	}
	
	public void initial(){
		buffer.clear();
		getAccountManageList();
	}

	@Override
	public Iterator<AccountVO> getAccountManageList() {
		// TODO Auto-generated method stub
		ArrayList<AccountPO> pos = dateController.getAccountList();
		accounts = new ArrayList<>(pos.size());
		for(AccountPO po:pos){
			accounts.add(new AccountVO(po));
		}
		return accounts.iterator();
		
	}

	@Override
	public ResultMessage addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		accounts.add(vo);
		return buffer.addCommond(new AddAccountCmd(vo));
	}

	@Override
	public ResultMessage deleteAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		accounts.remove(vo);
		return buffer.addCommond(new DeleteAccountCmd(vo));
	}

	@Override
	public ResultMessage modifyAccount(AccountVO vo) {
		//accountVO在名字相同的情况下视为相同
		int index = accounts.indexOf(vo);
		if(index == -1){
			return ResultMessage.FAILED;
		}
		else{
			accounts.set(index, vo);
			buffer.addCommond(new ModifyAccountCmd(vo));
			return ResultMessage.SUCCEED;
		}
	}

	@Override
	public ArrayList<AccountSearchResult> searchAccount(String keyword) {
		// TODO Auto-generated method stub
		AccountSearcher searcher = new AccountSearcher(accounts);
		return searcher.search(keyword);
		
	}

	@Override
	public ResultMessage confirm() {
		// TODO Auto-generated method stub
		return buffer.flush();
	}


	

}
