package gap.client.ui.inventoryui.stockinorderinput;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

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
		
		JPanel panel = new JPanel();
		gcons.insets = new Insets(0,10,0,10);
//		gcons.fill = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, stockinInfo, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 4, 1, 1, 1, 0);
		
		
	}
}
