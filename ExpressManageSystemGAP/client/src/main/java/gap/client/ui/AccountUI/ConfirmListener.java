package gap.client.ui.AccountUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gap.client.bl.account.AccountBlController;
import gap.common.util.ResultMessage;

public class ConfirmListener implements ActionListener{
	AccountBlController accountBlController;
	public ConfirmListener(AccountBlController controller) {
		accountBlController = controller;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ResultMessage message = accountBlController.confirm();
		if(message.equals(ResultMessage.SUCCEED)){
			System.out.println(message);
		}
	}

}
