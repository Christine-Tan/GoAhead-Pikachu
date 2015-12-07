package gap.client.ui.inventoryui.initialstock;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	JLabel id, order_id, destination, inDate, location;

	public TitlePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 80));

		id = new GAPLabel("编号");
		order_id = new GAPLabel("快递单号");
		inDate = new GAPLabel("入库日期");
		destination = new GAPLabel("目的地");
		location = new GAPLabel("存放位置");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.insets = new Insets(20, 32, 0, -12);
		SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(20, -15, 0, 10);
		SwingConsole.addComponent(gb, gcons, this, order_id, 1, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(20, 10, 0, 10);
		SwingConsole.addComponent(gb, gcons, this, destination, 2, 0, 1, 1, 1,
				0);
		gcons.insets = new Insets(20, 10, 0, 10);
		SwingConsole.addComponent(gb, gcons, this, inDate, 3, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(20, -10, 0, 55);
		SwingConsole.addComponent(gb, gcons, this, location, 4, 0, 1, 1, 1, 0);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}

}
