package gap.client.ui.bussinessui.drivermanage;

import gap.client.ui.UITools.Defaut;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class QueryPanel extends JPanel {
	GAPTextField id;
	JButton search;

	public QueryPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 80));

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		id = new GAPTextField(10);
		search = new GAPButton("搜索");
		gcons.insets = new Insets(10, 10, 0, 10);
		SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, search, 1, 0, 1, 1, 0, 0);
	}
}
