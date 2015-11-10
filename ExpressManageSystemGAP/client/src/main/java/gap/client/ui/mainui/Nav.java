package gap.client.ui.mainui;

import gap.client.ui.util.Defaut;
import gap.client.ui.util.UIColor;
import gap.client.ui.util.UIFont;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nav extends JLabel implements NavItem {
	String name;
	ImageIcon image;
	boolean selected;

	public Nav(String name, ImageIcon image) {
		this.name = name;
		this.image = image;
		setFont(UIFont.NavFont);
	}

	@Override
	public void setSelected() {
		// TODO 自动生成的方法存根
		selected = true;
		repaint();
	}

	@Override
	public void cancelSelected() {
		// TODO 自动生成的方法存根
		selected = false;
		repaint();
	}

	@Override
	public Component getComponent() {
		// TODO 自动生成的方法存根
		return this;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(UIFont.NavFont);
		if (selected) {
			g.setColor(UIColor.MESSAGE_BLUE);
			g.fillRect(Defaut.INSETS, 0, getWidth(), getHeight());
			g.setColor(Color.white);
			g.drawString(name, 100, 30);
		} else {
			g.setColor(UIColor.BACK_GRAY);
			g.fillRect(Defaut.INSETS, 0, getWidth(), getHeight());
			g.setColor(UIColor.MESSAGE_BLUE);
			g.drawString(name, 100, 30);
		}
	}

}
