package gap.client.ui.AccountUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gap.client.blcontroller.AccountBlController;
import gap.client.ui.AccountUI.AccountManagePanel;
import gap.common.util.ResultMessage;

/**
 * 财务人员确认所有修改，去数据库改内容
 * @author 申彬
 *
 */
public class AccountConfirmListener implements ActionListener{
	AccountManagePanel managePanel;
	public AccountConfirmListener(AccountManagePanel managePanel) {
		this.managePanel = managePanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		managePanel.confirmAllChange();
		
	}

}
