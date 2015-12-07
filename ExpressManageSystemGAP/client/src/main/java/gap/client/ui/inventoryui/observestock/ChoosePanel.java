package gap.client.ui.inventoryui.observestock;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoosePanel extends JPanel {
	JButton car, train, plane, flex;

	public ChoosePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 50));
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
				ComponentStyle.light_gray));

		car = new GAPButton("汽运区");
		car.setBorder(ComponentStyle.focus_border);
		car.setSize(80, 50);
		train = new GAPButton("铁运区");
		train.setBorder(ComponentStyle.focus_border);
		train.setSize(80, 50);
		plane = new GAPButton("航运区");
		plane.setBorder(ComponentStyle.focus_border);
		plane.setSize(80, 50);
		flex = new GAPButton("机动区");
		flex.setBorder(ComponentStyle.focus_border);
		flex.setSize(80, 50);

		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(200, 50));
		panel1.setBackground(null);
		panel1.setOpaque(false);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(200, 50));
		panel2.setBackground(null);
		panel2.setOpaque(false);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.insets = new Insets(0, 0, 0, 0);
		gcons.fill = GridBagConstraints.HORIZONTAL;
		// gcons.anchor = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, car, 1, 0, 1, 1, 0.5, 0);
		SwingConsole.addComponent(gb, gcons, this, train, 2, 0, 1, 1, 0.5, 0);
		SwingConsole.addComponent(gb, gcons, this, plane, 3, 0, 1, 1, 0.5, 0);
		SwingConsole.addComponent(gb, gcons, this, flex, 4, 0, 1, 1, 0.5, 0);
		SwingConsole.addComponent(gb, gcons, this, panel2, 5, 0, 1, 1, 1, 0);

	}

}
