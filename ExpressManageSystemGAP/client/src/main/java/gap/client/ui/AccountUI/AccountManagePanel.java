package gap.client.ui.AccountUI;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import gap.client.bl.account.AccountBlController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.BaseComponents.MainPanelWithGird;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.vo.AccountVO;

public class AccountManagePanel extends MainPanelWithGird{

	AccountBlController accountBlController;
	ArrayList<AccountVO> accounts;
	ConfirmListener confirmListener;
	GAPButton confirmButton;
	
	ButtonArea area;
	AccountDisplayPanel accountDisplayPanel;
	
	private int column = 4;
	
	public AccountManagePanel(MainFrame frame) {
		super(frame);

		initial();
	}
	
	public void initial(){
		accountBlController = AccountBlController.getInstance();
		Iterator<AccountVO> itr = accountBlController.getAccountManageList();
		itrToList(itr);
		
		confirmListener = new ConfirmListener(accountBlController);
		confirmButton = new GAPButton("确认修改");
		
		confirmButton.addActionListener(confirmListener);
		
		accountDisplayPanel = new AccountDisplayPanel(this, accounts);
		SwingConsole.addComponent(gb, gcons, this, accountDisplayPanel, 0, 0, 1, 1, 1, 1);
		
		area = new ButtonArea();
		area.removeAll();
		area.add(confirmButton);
		gcons.anchor = GridBagConstraints.EAST;
		SwingConsole.addComponent(gb, gcons, this, area, 0, 1, 1, 1, 1, 0);
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
