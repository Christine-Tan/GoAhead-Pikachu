package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.ui.UITools.Defaut;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ListPanel extends JPanel{
	public ListPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH,450));
	}
}
