package gap.client.ui.bussinessui;

import gap.client.ui.UITools.Defaut;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	JLabel car_id, name, gender, id_card;

	public TitlePanel() {
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 80));
		car_id = new GAPLabel("司机编号");
		name = new GAPLabel("姓名");
		gender = new GAPLabel("性别");
		id_card = new GAPLabel("身份证号");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}
}
