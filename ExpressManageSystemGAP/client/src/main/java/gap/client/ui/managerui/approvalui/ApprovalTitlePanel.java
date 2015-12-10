package gap.client.ui.managerui.approvalui;

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

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPCheckBox;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

public class ApprovalTitlePanel extends JPanel {
	// 单据编号，类型，日期
	JTextField id, type, date;
	// 全选
	JLabel allSelected;
	GAPCheckBox select;
	boolean isSelected;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;

	public ApprovalTitlePanel() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 40));
		setBackground(Color.WHITE);

		id = new GAPTextField(20);
		type = new GAPTextField(13);
		date = new GAPTextField(10);
		select = new GAPCheckBox();
		allSelected = new GAPLabel("全选");

		id.setText("单据编号");
		type.setText("单据类型");
		date.setText("生成日期");

		id.setHorizontalAlignment(JTextField.CENTER);
		type.setHorizontalAlignment(JTextField.CENTER);
		date.setHorizontalAlignment(JTextField.CENTER);

		setLayout(gb);
		gcons.insets = new Insets(10, 50, 10, 150);
		SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, type, 1, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, date, 2, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 50, 10, 0);
		SwingConsole.addComponent(gb, gcons, this, allSelected, 3, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 5, 10, 30);
		SwingConsole.addComponent(gb, gcons, this, select, 4, 0, 1, 1, 0, 0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}
}
