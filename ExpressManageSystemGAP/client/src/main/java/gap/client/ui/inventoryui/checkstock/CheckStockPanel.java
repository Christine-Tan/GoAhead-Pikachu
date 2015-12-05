package gap.client.ui.inventoryui.checkstock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;


public class CheckStockPanel extends MainPanel{
	ButtonArea buttonArea;
	ListPanel list;
	
	public CheckStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub

		buttonArea = new ButtonArea();
		list = new ListPanel(10);
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		JPanel panel = new JPanel();
		//还差一个选项卡
		SwingConsole.addComponent(gb, gcons, this, list, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 2, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);
		
	}

}
