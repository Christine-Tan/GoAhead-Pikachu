package gap.client.ui.inventoryui.stockinorderinput;

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
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockinInfoUI extends JPanel {
	JLabel title, inDate, id;
	GAPTextField date_text, id_text;

	GridBagLayout gb;
	GridBagConstraints gcon;

	public StockinInfoUI() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 90));

		title = new GAPLabel("入库单信息 ：");
		title.setFont(ComponentStyle.defaultFont);

		inDate = new GAPLabel("入库日期  ：");
		inDate.setFont(ComponentStyle.defaultFont);
		date_text = new GAPTextField(8);
		String date = (new Date(System.currentTimeMillis())).toString();
		setInDate(date);

		id = new GAPLabel("入库单编号  ：");
		id.setFont(ComponentStyle.defaultFont);
		id_text = new GAPTextField(20);
		id_text.setControl("\\d"+"",20, 20);

		gb = new GridBagLayout();
		gcon = new GridBagConstraints();

		// gcon.anchor = GridBagConstraints.CENTER;
		setLayout(gb);
		gcon.insets = new Insets(20, -10, 10, 40);
		SwingConsole.addComponent(gb, gcon, this, title, 0, 0, 1, 1, 0, 0);
		// gcon.fill = GridBagConstraints.HORIZONTAL;
		gcon.insets = new Insets(20, 20, 10, 5);
		SwingConsole.addComponent(gb, gcon, this, inDate, 1, 0, 1, 1, 0, 0);
		gcon.insets = new Insets(20, 10, 10, 10);
		SwingConsole.addComponent(gb, gcon, this, date_text, 2, 0, 1, 1, 0, 0);
		gcon.insets = new Insets(20, 30, 10, 5);
		SwingConsole.addComponent(gb, gcon, this, id, 3, 0, 1, 1, 0, 0);
		gcon.insets = new Insets(20, 10, 10, 10);
		SwingConsole.addComponent(gb, gcon, this, id_text, 4, 0, 1, 1, 0, 0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);

		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}

	public void setInDate(String date) {
		date_text.setText(date);
		date_text.closeEdit();
	}

}
