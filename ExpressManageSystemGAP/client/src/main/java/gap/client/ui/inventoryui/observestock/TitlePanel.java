package gap.client.ui.inventoryui.observestock;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box.Filler;

public class TitlePanel extends JPanel {
	JLabel id, inDate, order_id, sector, amount;

	public TitlePanel(String orderName) {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 50));

		
		id = new GAPLabel("编号");
		order_id = new GAPLabel(orderName +"单编号");
		inDate = new GAPLabel(orderName+"日期");
		amount = new GAPLabel("数量");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.anchor = GridBagConstraints.CENTER;
		gcons.insets = new Insets(0, 2, 0, 18);
		SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, 0, 0, 20);
		SwingConsole.addComponent(gb, gcons, this, order_id, 1, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, 12, 0, 8);
		SwingConsole.addComponent(gb, gcons, this, inDate, 2, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, 12, 0, 8);
		SwingConsole.addComponent(gb, gcons, this, amount, 3, 0, 1, 1, 1, 0);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(20, height - 5, width - 30, height - 5);
	}

}
