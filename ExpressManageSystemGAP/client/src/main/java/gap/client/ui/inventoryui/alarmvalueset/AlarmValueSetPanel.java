package gap.client.ui.inventoryui.alarmvalueset;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class AlarmValueSetPanel extends MainPanel{
	
	ButtonArea buttonArea;
	AlarmValueUI alarmValue;
	
	public AlarmValueSetPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		buttonArea = new ButtonArea();
		alarmValue = new AlarmValueUI();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		gcons.fill = GridBagConstraints.HORIZONTAL;
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(850, 220));
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension(850, 260));
		// sender.setBackground(Color.red);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, alarmValue, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 2, 1, 1, 1, 0);
//		gcons.fill = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);
		
	}

}
