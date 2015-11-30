package gap.client.ui.bussinessui.expressorderinput;

import gap.client.ui.UITools.Defaut;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonArea extends JPanel {
	public JButton submit;

	public ButtonArea() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 80));

		submit = new GAPButton("提交订单");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets=new Insets(10, 10, 10, 50);
		gcons.anchor = GridBagConstraints.EAST;
		SwingConsole.addComponent(gb, gcons, this, submit, 0, 0, 1, 1, 1, 0);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, 5, width - 20, 5);
	}
}
