package gap.client.ui.inventoryui.initialstock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;

public class InitialStockPanel extends MainPanel{
	ButtonArea confirm;
	ListItemPanel list;
	TitlePanel title;

	public InitialStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		confirm = new ButtonArea();
		list = new ListItemPanel(frame);
		title = new TitlePanel();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		JPanel panel = new JPanel();
		//还差一个选项卡
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 4, 1, 1, 1, 0);
	}

}
