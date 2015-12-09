package gap.client.ui.inventoryui.initialstock;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

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
	GAPTextField id, order_id, destination, inDate, location;

	public TitlePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 80));

		id = new GAPTextField("编号",3);
		id.setCenter();
		id.closeEdit();
		
		order_id = new GAPTextField("快递单号",7);
		order_id.setCenter();
		order_id.closeEdit();
		
		inDate = new GAPTextField("入库日期",7);
		inDate.setCenter();
		inDate.closeEdit();
		
		destination = new GAPTextField("目的地",11);
		destination.setCenter();
		destination.closeEdit();
		
		location = new GAPTextField("存放位置",7);
		location.setCenter();
		location.closeEdit();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(35,10));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension(5,10));
		
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, -30, 0, 20);
		SwingConsole.addComponent(gb, gcons, this, this.id, 1, 0, 1, 1, 1,
				0);
		gcons.insets = new Insets(0, -12, 0, 12);
		SwingConsole.addComponent(gb, gcons, this, order_id, 2, 0, 1, 1, 1,
				0);
		gcons.insets = new Insets(0, 8, 0, 16);
		SwingConsole.addComponent(gb, gcons, this, destination, 3, 0, 1, 1,
				1, 0);
		gcons.insets = new Insets(0, 4, 0, 12);
		SwingConsole
				.addComponent(gb, gcons, this, inDate, 4, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, 8, 0, 2);
		SwingConsole.addComponent(gb, gcons, this, location, 5, 0, 1, 1, 1,
				0);
		SwingConsole.addComponent(gb, gcons, this, panel, 6, 0, 1, 1, 1, 0);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}

}
