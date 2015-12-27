package gap.client.ui.initialUI;

import java.util.List;

import gap.client.ui.paymentUI.PanelWithGrid;
import gap.common.po.InitialHistoryPO;

public class InitialHistoryPanel extends PanelWithGrid{

	InitialMainPanel mainPanel;
	List<InitialHistoryPO> historyPOs;
	
	public InitialHistoryPanel(InitialMainPanel mainPanel,List<InitialHistoryPO> historyPOs){
		this.mainPanel = mainPanel;
		this.historyPOs = historyPOs;
	}
}
