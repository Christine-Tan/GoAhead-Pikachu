package gap.client.bl.account;

import gap.client.vo.AccountVO;
import gap.common.po.AccountPO;
import gap.common.util.ResultMessage;

public class DeleteAccountCmd extends AccountCommond{

	public DeleteAccountCmd(AccountVO vo){
		super(vo);
	}
	@Override
	public ResultMessage excute() {
		// TODO Auto-generated method stub
		return accountDateController.deleteAccount(po);
		
	}
	
	
}
