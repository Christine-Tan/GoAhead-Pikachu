package gap.client.ui.inventoryui.stockinorderinput;

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

public class TitlePanel extends JPanel {
	Checkbox box;
	JLabel id, inDate, destination, sector, location;

	public TitlePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 50));

		box = new Checkbox();

		id = new GAPLabel("快递编号");
		inDate = new GAPLabel("入库日期");
		destination = new GAPLabel("目的地");
		sector = new GAPLabel("分区");
		location = new GAPLabel("存放位置");
		
		

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		
		gcons.anchor = GridBagConstraints.CENTER;
		gcons.insets = new Insets(0, 1, 0, 19);
		SwingConsole.addComponent(gb, gcons, this, box, 0, 0, 1, 1, 1, 0);
		
		gcons.anchor = GridBagConstraints.CENTER;
		gcons.insets = new Insets(0, -40, 0, 60);
		SwingConsole.addComponent(gb, gcons, this, id, 1, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, -45, 0, 65);
		SwingConsole.addComponent(gb, gcons, this, inDate, 2, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, -30, 0, 50);
		SwingConsole.addComponent(gb, gcons, this, destination, 3, 0, 1, 1, 1,
				0);
		gcons.insets = new Insets(0, -7, 0, 27);
		SwingConsole.addComponent(gb, gcons, this, sector, 4, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(0, -10, 0, 30);
		SwingConsole.addComponent(gb, gcons, this, location, 5, 0, 1, 1, 1, 0);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(20, height - 5, width - 20, height - 5);
	}

}
