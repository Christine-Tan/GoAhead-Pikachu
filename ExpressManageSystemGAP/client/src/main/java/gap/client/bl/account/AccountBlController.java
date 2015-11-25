package gap.client.bl.account;

import java.util.ArrayList;

import gap.client.blservice.accountblservice.AccountService;
import gap.client.vo.AccountVO;
import gap.common.util.ResultMessage;

public class AccountBlController implements AccountService{

	AccountCmdBuffer buffer;
	private static AccountBlController controller=null;
	
	private AccountBlController() {
		buffer = new AccountCmdBuffer();
	}
	
	public static AccountBlController getInstance(){
		
		if(controller==null){
			controller = new AccountBlController();
		}

		return controller;
	}

	@Override
	public ArrayList<AccountVO> getAccountManageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage confirm() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
