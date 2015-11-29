package gap.client.ui.bussinessui;

import gap.client.ui.UITools.SwingConsole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CargoInfoUI extends JPanel {
	JLabel title, name, number, weight, volumn;
	JTextField name_text, number_text, weight_text, volunm_text;
	final int RIGHT_INSERT=115;

	public CargoInfoUI() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(850, 150));

		// 初始化组件
		title = new GAPLabel("货物信息：");

		name = new GAPLabel("货物名称:");
		name_text = new GAPTextField(10);

		number = new GAPLabel("内件数量:");
		number_text = new GAPTextField(10);

		weight = new GAPLabel("货物重量:");
		weight_text = new GAPTextField(10);

		volumn = new GAPLabel("货物体积:");
		volunm_text = new GAPTextField(10);
		
		//布局
		
		GridBagLayout gb=new GridBagLayout();
		GridBagConstraints gcons=new GridBagConstraints();
		gcons.insets=new Insets(10, 10, 10, 10);
		gcons.fill=GridBagConstraints.HORIZONTAL;
		setLayout(gb);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, name, 1, 0, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, RIGHT_INSERT);
//		gcons.anchor=GridBagConstraints.PAGE_END;
		SwingConsole.addComponent(gb, gcons, this, name_text, 2, 0, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, 10);
		SwingConsole.addComponent(gb, gcons, this, number, 3, 0, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, number_text, 4, 0, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, 10);
		SwingConsole.addComponent(gb, gcons, this, weight, 1, 1, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, weight_text, 2, 1, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, 10);
		SwingConsole.addComponent(gb, gcons, this, volumn, 3, 1, 1, 1, 0, 0);
		gcons.insets=new Insets(10, 10, 10, RIGHT_INSERT);
		SwingConsole.addComponent(gb, gcons, this, volunm_text, 4, 1, 1, 1, 0, 0);
	}

//	public static void main(String[] args) {
//		JFrame jf = new JFrame();
//		jf.setContentPane(new CargoInfoUI());
//		SwingConsole.run(jf, 900, 150);
//	}
}
