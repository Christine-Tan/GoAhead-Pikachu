package gap.client.ui.bussinessui.billorderui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;

public class BillOrderPanel extends MainPanel {

	TitlePanel title;
	ListItemPanel listItem;
	ButtonArea buttonArea;

	public BillOrderPanel(MainFrame frame) {
		super(frame);
		// TODO 自动生成的构造函数存根
		setBackground(Color.white);

		title = new TitlePanel();
		listItem = new ListItemPanel(frame);
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("提交订单");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setOpaque(false);

		SwingConsole.addComponent(gb, gcons, this, title, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, listItem, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 2, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);

	}

}
