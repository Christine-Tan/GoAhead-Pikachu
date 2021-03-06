package gap.client.ui.bussinessui.carmanage;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CarQueryPanel extends JPanel {
	GAPTextField id;
	JButton search;

	public CarQueryPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 80));

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		id = new GAPTextField(10);
		search = new GAPButton("搜索", new ImageIcon(
				"images\\deliveryIcon\\search.png"));
		search.setFont(ComponentStyle.plainFont);
//		search.setForeground(Color.black);
		gcons.insets = new Insets(10, 0, 0, 2);
		SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, search, 1, 0, 1, 1, 0, 0);
	}

	public String getKey() {
		return id.getText();
	}

	public JButton getButton() {
		return search;
	}

	public void clear() {
		id.setText("");
	}
}
