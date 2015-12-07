package gap.client.bl.account;

import gap.client.vo.AccountVO;
import gap.common.util.ResultMessage;

public class AddAccountCmd extends AccountCommond {

	public AddAccountCmd(AccountVO vo) {
		super(vo);
	}

	@Override
	public ResultMessage excute() {
		// TODO Auto-generated method stub
		return accountDateController.addAccount(po);

	}

}
