package gap.client.ui.administratorui.userui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;

public class TitlePanel extends JPanel {
	JLabel user_id, user_name, password, name, user_type, gender, ins_name;

	public TitlePanel() {
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 50));
		setBackground(Color.WHITE);
		user_id = new GAPLabel("用户ID");
		user_name = new GAPLabel("用户名");
		password = new GAPLabel("密码");
		name = new GAPLabel("姓名");
		user_type = new GAPLabel("用户类型");
		gender = new GAPLabel("性别");
		ins_name = new GAPLabel("所属机构");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.insets = new Insets(10, 0, 10, 0);
		SwingConsole.addComponent(gb, gcons, this, user_id, 0, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 45, 10, 0);
		SwingConsole.addComponent(gb, gcons, this, user_name, 1, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 45, 10, 20);
		SwingConsole.addComponent(gb, gcons, this, password, 2, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 45, 10, 8);
		SwingConsole.addComponent(gb, gcons, this, name, 3, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 45, 10, 25);
		SwingConsole.addComponent(gb, gcons, this, user_type, 4, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 45, 10, 25);
		SwingConsole.addComponent(gb, gcons, this, gender, 5, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 45, 10, 25);
		SwingConsole.addComponent(gb, gcons, this, ins_name, 6, 0, 1, 1, 0, 0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}
}
