package gap.client.ui.UITools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingConsole {
	private SwingConsole() {}

	public static void addComponent(GridBagLayout gb, GridBagConstraints gcons,
			JPanel pa, Component com, int x, int y, int w, int h, double wx,
			double wy) {
		pa.add(com);
		gcons.gridx = x;
		gcons.gridy = y;
		gcons.gridheight = h;
		gcons.gridwidth = w;
		gcons.weightx = wx;
		gcons.weighty = wy;
		gb.setConstraints(com, gcons);
	}
}
