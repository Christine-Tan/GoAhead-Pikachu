package gap.client.ui.inventoryui.alarmvalueset;

import gap.client.ui.UITools.Default;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Value extends JPanel{
	Icon icon;
	public Value(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,400));
	}
}
