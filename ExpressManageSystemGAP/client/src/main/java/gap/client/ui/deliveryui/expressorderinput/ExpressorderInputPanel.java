package gap.client.ui.deliveryui.expressorderinput;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ExpressorderInputPanel extends MainPanel {
	PeopleInfoUI sender, receiver;
	CargoInfoUI cargo;
	ExpressInfoUI express;
	ButtonArea buttonArea;

	public ExpressorderInputPanel(MainFrame frame) {
		super(frame);
		sender = new PeopleInfoUI("寄件人信息：");
		receiver = new PeopleInfoUI("收件人信息：");
		cargo = new CargoInfoUI();
		express = new ExpressInfoUI();
		buttonArea = new ButtonArea();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.fill = GridBagConstraints.HORIZONTAL;
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension(850, 20));
		// sender.setBackground(Color.red);
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, sender, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, receiver, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, cargo, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, express, 0, 4, 1, 1, 1, 0);
		gcons.fill = GridBagConstraints.BOTH;
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 5, 1, 1, 1, 1);
		gcons.fill = GridBagConstraints.HORIZONTAL;
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 7, 1, 1, 1, 0);
	}

	// public static void main(String[] args) {
	//
	// BussinessPanel pa = new BussinessPanel();
	// JScrollPane js = new GAPJScrollPane(pa);
	// JFrame jf = new JFrame();
	// jf.setContentPane(js);
	// // jf.getContentPane().add(pa);
	// jf.setSize(1027, 768);
	// jf.setVisible(true);
	// jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//
	// }
}
