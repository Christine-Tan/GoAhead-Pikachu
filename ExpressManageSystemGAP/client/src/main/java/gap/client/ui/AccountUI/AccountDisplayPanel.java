package gap.client.ui.AccountUI;

import java.util.ArrayList;

import javax.swing.JPanel;

import gap.client.vo.AccountVO;

public class AccountDisplayPanel extends JPanel{

	ArrayList<AccountVO> accounts;
	AccountManagePanel accountManagePanel;
	public AccountDisplayPanel(AccountManagePanel accountManagePanel, ArrayList<AccountVO> accountVOs){
		accounts = accountVOs;
		this.accountManagePanel = accountManagePanel;
	}
	
	public void addAccountBox(){
		add(new AccountBox(this));
	}
	
}
