package gap.client.ui.inventoryui.stockoutorderinput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;

public class StockoutOrderInputPanel extends MainPanel{
	StockoutInfoPanel stockoutInfo;
	ListPanel list;
	ButtonArea confirm;
	TitlePanel title;
	
	public StockoutOrderInputPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		stockoutInfo = new StockoutInfoPanel();
		confirm = new ButtonArea();
		list = new ListPanel();
		title = new TitlePanel();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		JPanel panel = new JPanel();
		SwingConsole.addComponent(gb, gcons, this, stockoutInfo, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 4, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 5, 1, 1, 1, 0);
	}

}
