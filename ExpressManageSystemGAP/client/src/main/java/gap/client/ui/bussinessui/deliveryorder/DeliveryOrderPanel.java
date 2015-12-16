package gap.client.ui.bussinessui.deliveryorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;

/**
 * 快递员选择列表
 * @author YangYanfei
 *
 */
public class DeliveryOrderPanel extends MainPanel {
	MainContentPanel mainContentPanel;
	DeliverySelectPanel deliverySelect;
	ButtonArea buttonArea;

	public DeliveryOrderPanel(MainFrame frame) {
		super(frame);
		setBackground(Color.red);
		mainContentPanel = new MainContentPanel(frame);
		deliverySelect = new DeliverySelectPanel(frame);
		mainContentPanel.setDeleverySelectPanel(deliverySelect);
		deliverySelect.setMainContentPanel(mainContentPanel);

		deliverySelect.refresh();
		
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("生成派件单");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		gcons.fill = GridBagConstraints.BOTH;
		setLayout(gb);
//		gcons.ipadx = 200;
		SwingConsole.addComponent(gb, gcons, this, deliverySelect, 0, 0, 1, 1,
				0, 1);
		gcons.ipadx = 0;
		SwingConsole.addComponent(gb, gcons, this, mainContentPanel, 1, 0, 1,
				1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 1, 2, 1, 1, 0);
	}

}
