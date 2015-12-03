package gap.client.ui.inventoryui.stockinorderinput;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;

public class StockinOrderInputPanel extends MainPanel{
	StockinInfoUI stockinInfo;
	TitlePanel title;
	ButtonArea confirm;
	ListPanel list;
	
	public StockinOrderInputPanel(MainFrame frame){
		super(frame);
		
		stockinInfo = new StockinInfoUI();
		title = new TitlePanel();
		confirm = new ButtonArea();
		list = new ListPanel();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		SwingConsole.addComponent(gb, gcons, this, stockinInfo, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 8, 1, 1, 1, 0);
		
		
	}
}
