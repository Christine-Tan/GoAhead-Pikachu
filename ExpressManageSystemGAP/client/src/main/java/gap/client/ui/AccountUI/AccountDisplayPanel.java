package gap.client.ui.AccountUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import gap.client.ui.UITools.Default;
import gap.client.vo.AccountVO;

public class AccountDisplayPanel extends JPanel{

	ArrayList<AccountVO> accounts;
	AccountManagePanel accountManagePanel;
	
	HashMap<AccountBox, AccountVO> accountMap;
	public AccountDisplayPanel(AccountManagePanel accountManagePanel, ArrayList<AccountVO> accountVOs){
		accounts = accountVOs;		
		this.accountManagePanel = accountManagePanel;
		accountMap = new HashMap<>(accounts.size());
		setOpaque(false);
		
		//setPreferredSize(new Dimension(Default.PANEL_WIDTH, 1500));
		//setMinimumSize(new Dimension(Default.PANEL_WIDTH, Default.NAV_HEIGHT));
		//setMaximumSize(new Dimension(Default.PANEL_WIDTH, 2500));
		
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 50, 10);
		setLayout(flowLayout);
		addAccountBox();
	}
	
	public void addAccountBox(){
		for(AccountVO vo : accounts){
			AccountBox box = new AccountBox(this, vo);
			accountMap.put(box, vo);
			add(box);
		}
		
	}
	
}
