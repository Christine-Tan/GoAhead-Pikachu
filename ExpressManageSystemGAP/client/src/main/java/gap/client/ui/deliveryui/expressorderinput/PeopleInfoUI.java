package gap.client.ui.deliveryui.expressorderinput;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.GapTextControll;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPComboBox;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.common.util.PeopleInfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PeopleInfoUI extends JPanel {
	GAPLabel title, name, phone, address, province, city, district;
	GAPTextField name_text, phone_text, depart_text;
	JComboBox<String> pro_list, city_list, dis_list;
	GridBagLayout grid;
	GridBagConstraints gcon;

	public PeopleInfoUI(String titleName) {

		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 150));
		// setSize(0,200);

		// 初始化组件
		title = new GAPLabel(titleName);
		title.setFont(ComponentStyle.defaultFont);
		// title.set/
		name = new GAPLabel("姓名");
		name.setFont(ComponentStyle.defaultFont);
		name_text = new GAPTextField();

		phone = new GAPLabel("电话");
		phone.setFont(ComponentStyle.defaultFont);
		phone_text = new GAPTextField(15);
		phone_text.setControl("", 11, 11);
		// phone_text.setDocument(GapTextControll.getNumberDocument(11));

		address = new GAPLabel("住址");

		province = new GAPLabel("省");
		pro_list = new GAPComboBox<String>();
		pro_list.addItem("北京市");
		pro_list.addItem("江苏");
		// pro_list.setFocusable(false);

		city = new GAPLabel("市");
		city_list = new GAPComboBox<String>();
		city_list.addItem("北京市");
		city_list.addItem("南京");

		district = new GAPLabel("区");
		dis_list = new GAPComboBox<String>();
		dis_list.addItem("栖霞区1");
		dis_list.addItem("栖霞区2");
		dis_list.addItem("栖霞区3");
		dis_list.addItem("栖霞区4");
		dis_list.addItem("栖霞区5");
		dis_list.addItem("栖霞区6");
		dis_list.addItem("栖霞区7");
		dis_list.addItem("栖霞区8");

		depart_text = new GAPTextField();

		// 布局
		grid = new GridBagLayout();
		gcon = new GridBagConstraints();
		gcon.insets = new Insets(10, 10, 10, 10);
		gcon.anchor = GridBagConstraints.CENTER;
		setLayout(grid);
		SwingConsole.addComponent(grid, gcon, this, title, 0, 0, 1, 1, 0, 0);
		gcon.fill = GridBagConstraints.HORIZONTAL;
		SwingConsole.addComponent(grid, gcon, this, name, 1, 0, 1, 1, 0, 0);
		SwingConsole
				.addComponent(grid, gcon, this, name_text, 2, 0, 3, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, phone, 8, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, phone_text, 9, 0, 1, 1, 0,
				0);
		SwingConsole.addComponent(grid, gcon, this, address, 1, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, pro_list, 2, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, province, 3, 1, 1, 1, 0, 0);
		SwingConsole
				.addComponent(grid, gcon, this, city_list, 4, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, city, 5, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, dis_list, 6, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, district, 7, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, depart_text, 8, 1, 2, 1, 0,
				0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, height - 5, width - 20, height - 5);
	}

	// public PeopleInfo getPeopleInfo(){
	//
	// return new PeopleInfo(name_text.getText(), , depart, cellphone)
	// }
	// public static void main(String[] args) {
	// JFrame jf = new JFrame();
	// jf.setContentPane(new PeopleInfoUI("寄件人信息"));
	// SwingConsole.run(jf, 900, 150);
	// }

}
