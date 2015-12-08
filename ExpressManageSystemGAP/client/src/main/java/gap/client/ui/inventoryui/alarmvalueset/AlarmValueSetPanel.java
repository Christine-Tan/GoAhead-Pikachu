package gap.client.ui.inventoryui.alarmvalueset;

import gap.client.blcontroller.InventoryController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.util.LocalInfo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class AlarmValueSetPanel extends MainPanel {

	ButtonArea buttonArea;
	AlarmValueUI alarmValue;

	public AlarmValueSetPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub

		buttonArea = new ButtonArea();
		buttonArea.submit.setText("确认");
		alarmValue = new AlarmValueUI();

		buttonArea.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InventoryController.setAlarmValue(alarmValue.getAlarmValue(),
						LocalInfo.getIns_ID());
				alarmValue.alarmValue.closeEdit();
				// InventoryController.setAlarmValue(alarmValue, ins_id);
			}

		});

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.fill = GridBagConstraints.HORIZONTAL;
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 0, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, alarmValue, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 2, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);

	}

}
