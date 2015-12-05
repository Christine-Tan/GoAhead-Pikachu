package gap.client.ui.bussinessui.loadorder;

import gap.client.blcontroller.LoadOrderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.util.LocalInfo;
import gap.client.vo.LoadOrderVO;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JPanel;

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
		buttonArea.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				LoadOrderController.save(getLoadOrder());
			}
		});

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

	public LoadOrderVO getLoadOrder() {
		LoadOrderVO loadOrder = new LoadOrderVO();
		loadOrder.car_id = carAndDriver.getCar().getCar_id();
		loadOrder.driver_id = carAndDriver.getDriver().getId();
		loadOrder.departureins_id = LocalInfo.ins_id;
		loadOrder.guard_id = LocalInfo.getUserID();
		loadOrder.orders = orderPanel.getOrders();
		loadOrder.date = (new Date(System.currentTimeMillis())).toString();
		loadOrder.comment = desAddressPanel.getComment();
		loadOrder.targetins_id = desAddressPanel.getTargetIns_id();
		return loadOrder;
	}

}
