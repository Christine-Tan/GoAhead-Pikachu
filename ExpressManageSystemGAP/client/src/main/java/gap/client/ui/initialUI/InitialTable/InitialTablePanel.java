package gap.client.ui.initialUI.InitialTable;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.List;

import javax.swing.JViewport;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.initialUI.InitialMainPanel;
import gap.client.ui.initialUI.initialAccount.AccountDisplayPanel;
import gap.client.ui.initialUI.initialAccount.InitialAccountPanel;
import gap.client.ui.paymentUI.PanelWithGrid;
import gap.common.po.InitialHistoryPO;
import gap.common.po.InitialPeoplePO;

public class InitialTablePanel extends PanelWithGrid{
	
	List<InitialPeoplePO> peoplePOs;
	
	CityTableHeader tableHeader;
	CityTableContant tableContant;
	InitialAccountPanel accountPanel;
	
	public InitialTablePanel(InitialMainPanel mainPanel,InitialHistoryPO historyPO){

		this.peoplePOs = historyPO.initialPeoplePOs;
		
		String[] cityNames = new String[peoplePOs.size()];
		for(int i=0;i<peoplePOs.size();i++){
			cityNames[i] = peoplePOs.get(i).getCityName();
		}
		
		tableHeader = new CityTableHeader(cityNames);
		tableContant = new CityTableContant(peoplePOs);
		
		JViewport viewport = mainPanel.getJsPanel().getViewport();
		
		accountPanel = new InitialAccountPanel(mainPanel, historyPO.accountPOs,viewport);
		
		gridBagConstraints.fill = GridBagConstraints.NONE;
		
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, tableHeader, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, tableContant, 0, 1, 1, 1, 1, 1);
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, accountPanel, 0, 2, 1, 1, 1, 1);
		
	}
}
