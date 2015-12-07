package gap.client.bl.account;

import gap.client.vo.AccountVO;
import gap.common.util.ResultMessage;

public class ModifyAccountCmd extends AccountCommond {

	public ModifyAccountCmd(AccountVO vo) {
		super(vo);
	}

	@Override
	public ResultMessage excute() {
		return accountDateController.modifyAccount(po);
	}
}
