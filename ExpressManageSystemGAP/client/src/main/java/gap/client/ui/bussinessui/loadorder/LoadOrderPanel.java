package gap.client.ui.bussinessui.loadorder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;

public class LoadOrderPanel extends MainPanel {
	CarAndDriverPanel carAndDriver;
	OrderPanel orderPanel;
	ButtonArea buttonArea;
	DesAddressPanel desAddressPanel;

	public LoadOrderPanel(MainFrame frame) {
		super(frame);
		carAndDriver = new CarAndDriverPanel();
		orderPanel = new OrderPanel(frame);
		buttonArea = new ButtonArea();
		desAddressPanel = new DesAddressPanel();
		buttonArea.submit.setText("生成装车单");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		JPanel jp = new JPanel();
		jp.setOpaque(false);

		SwingConsole.addComponent(gb, gcons, this, carAndDriver, 0, 0, 1, 1, 1,
				0);
		SwingConsole
				.addComponent(gb, gcons, this, orderPanel, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 2, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, desAddressPanel, 0, 3, 1, 1,
				1, 0);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 4, 1, 1, 1, 0);
	}

}
