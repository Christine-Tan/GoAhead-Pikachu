package gap.client.ui.inventoryui.alarmvalueset;

import gap.client.blcontroller.InventoryController;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.util.LocalInfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlarmValueUI extends JPanel {
	public GAPTextField alarmValue;

	// public JScrollPane scroller;

	public AlarmValueUI() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 120));

		alarmValue = new GAPTextField(10);
		alarmValue.setBorder(ComponentStyle.text_border);
		alarmValue.setFont(new Font("微软雅黑", Font.PLAIN, 60));
		alarmValue.setHorizontalAlignment(JTextField.CENTER);
		alarmValue.setForeground(ComponentStyle.gray);
		System.out.println(LocalInfo.getIns_ID());

		double value = InventoryController.getAlarmValue(LocalInfo.getIns_ID());
		alarmValue.setText(value + "%");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets = new Insets(10, 10, 10, 10);
		SwingConsole
				.addComponent(gb, gcons, this, alarmValue, 0, 0, 1, 1, 1, 0);
	}

	public double getAlarmValue() {
		String newValue = alarmValue.getText();
		newValue = newValue.split("%")[0];
		System.out.println();
		return Double.parseDouble(newValue);
	}
}
