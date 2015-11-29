package gap.client.ui.bussinessui;

import gap.client.ui.UITools.SwingConsole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

public class ExpressInfoUI extends JPanel {
	JLabel title, type;
	JComboBox<String> type_list;

	public ExpressInfoUI() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(850, 100));

		// 初始化组件
		title = new GAPLabel("快件信息：");

		type = new GAPLabel("快递类型：");

		type_list = new GAPComboBox<String>();
		type_list.addItem("特快");
		type_list.addItem("经济");
		type_list.addItem("标准");
		type_list.setSelectedIndex(2);

		// 布局
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		gcons.insets = new Insets(10, 10, 10, 10);
		gcons.fill = GridBagConstraints.HORIZONTAL;
		setLayout(gb);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, type, 1, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 10, 10, 540);
		SwingConsole.addComponent(gb, gcons, this, type_list, 2, 0, 1, 1, 0, 0);
	}

}
