package gap.client.ui.deliveryui.expressorderinput;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.common.util.CargoInfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 货物信息面板
 * @author YangYanfei
 *
 */
public class CargoInfoUI extends JPanel {
	JLabel title, name, number, weight, volumn;
	JTextField name_text, number_text, weight_text, volunm_text;
	final int RIGHT_INSERT = 23;

	public CargoInfoUI() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 150));

		// 初始化组件
		title = new GAPLabel("货物信息：");

		name = new GAPLabel("货物名称:");
		name_text = new GAPTextField(10);

		number = new GAPLabel("内件数量（单位：个）:");
		number_text = new GAPTextField(10);

		weight = new GAPLabel("货物重量（单位：kg）:");
		weight_text = new GAPTextField(10);

		volumn = new GAPLabel("货物体积（单位：m³）:");
		volunm_text = new GAPTextField(10);

		// 布局

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		gcons.insets = new Insets(10, 10, 10, 10);
		gcons.fill = GridBagConstraints.HORIZONTAL;
		setLayout(gb);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, name, 1, 0, 1, 1, 0, 0);

		gcons.insets = new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, name_text, 2, 0, 1, 1, 0, 0);

		gcons.insets = new Insets(10, 10, 10, 10);
		SwingConsole.addComponent(gb, gcons, this, number, 3, 0, 1, 1, 0, 0);

		gcons.insets = new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, number_text, 4, 0, 1, 1, 0,
				0);
		gcons.insets = new Insets(10, 10, 10, 10);
		SwingConsole.addComponent(gb, gcons, this, weight, 1, 1, 1, 1, 0, 0);

		gcons.insets = new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, weight_text, 2, 1, 1, 1, 0,
				0);
		gcons.insets = new Insets(10, 10, 10, 10);
		SwingConsole.addComponent(gb, gcons, this, volumn, 3, 1, 1, 1, 0, 0);

		gcons.insets = new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, volunm_text, 4, 1, 1, 1, 0,
				0);
	}

	// 画线
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}

	// 获得货物信息
	public CargoInfo getCargo() {
		return new CargoInfo(new Integer(number_text.getText()), new Double(
				weight_text.getText()), new Double(volunm_text.getText()),
				name_text.getText());
	}

	public void reSet() {
		name_text.setText("");
		number_text.setText("");
		weight.setText("");
		volumn.setText("");
	}
	// public static void main(String[] args) {
	// JFrame jf = new JFrame();
	// jf.setContentPane(new CargoInfoUI());
	// SwingConsole.run(jf, 900, 150);
	// }
}
