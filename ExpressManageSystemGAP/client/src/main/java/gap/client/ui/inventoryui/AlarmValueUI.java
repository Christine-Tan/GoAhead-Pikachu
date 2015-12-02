package gap.client.ui.inventoryui;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.*;

import javax.swing.*;


public class AlarmValueUI extends JPanel{
	public JTextField alarmValue;
	
	public AlarmValueUI(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,80));
		
		alarmValue = new GAPTextField(10);
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets=new Insets(10, 10, 10, 10);
		gcons.anchor = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, alarmValue, 0, 0, 1, 1, 1, 0);
	}
}
