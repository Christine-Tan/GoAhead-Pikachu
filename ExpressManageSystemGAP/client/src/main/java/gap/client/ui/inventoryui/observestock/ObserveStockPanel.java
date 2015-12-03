package gap.client.ui.inventoryui.observestock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;

public class ObserveStockPanel extends MainPanel{
	ButtonArea confirm;
	TitlePanel stockinTitle,stockoutTitle;
	ListPanel stockinList,stockoutList;
	TotalNumPanel stockinTotal,stockoutTotal,totalNum;
	ChoosePanel sectors;
	PeriodPanel period;
	
	public ObserveStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		confirm = new ButtonArea();
		stockinTitle = new TitlePanel("入库");
		stockoutTitle = new TitlePanel("出库");
		stockinList = new ListPanel();
		stockoutList = new ListPanel();
		stockinTotal = new TotalNumPanel("入库", "180");
		stockoutTotal = new TotalNumPanel("出库", "180");
		totalNum = new TotalNumPanel("库存","3600");
		sectors = new ChoosePanel();
		period = new PeriodPanel();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));
		SwingConsole.addComponent(gb, gcons, this, sectors, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, period, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockinTitle, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockinList, 0, 4, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockinTotal, 0, 5, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockoutTitle, 0, 6, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockoutList, 0, 7, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockoutTotal, 0, 8, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 9, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, totalNum, 0, 10, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 11, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 12, 1, 1, 1, 0);
	}

}
