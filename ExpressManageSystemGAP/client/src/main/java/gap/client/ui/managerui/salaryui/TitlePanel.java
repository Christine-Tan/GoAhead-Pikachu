package gap.client.ui.managerui.salaryui;

import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	JLabel usertype, money;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public TitlePanel() {
		usertype = new GAPLabel("人员类型");
		money = new GAPLabel("薪水价格");
		// 布局
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets = new Insets(40, 50, 10, 0);
		SwingConsole.addComponent(gb, gcons, this, usertype, 0, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(40, 130, 10, 450);
		SwingConsole.addComponent(gb, gcons, this, money, 1, 0, 1, 1, 0, 0);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}
}
