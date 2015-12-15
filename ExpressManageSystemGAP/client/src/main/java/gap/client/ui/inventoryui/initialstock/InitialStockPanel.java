package gap.client.ui.inventoryui.initialstock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.ChooseButton;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.util.LocalInfo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InitialStockPanel extends MainPanel {
	ButtonArea confirm;
	// ListItemPanelRaw list;
	TitlePanel title;
	ChoosePanel choose;
	ListItemPanel newList;
	String sector_id;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JFrame frame;

	public InitialStockPanel(final MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		this.frame = frame;

		confirm = new ButtonArea();
		confirm.submit.setText("确认初始化");
		title = new TitlePanel();
		choose = new ChoosePanel();
		newList = new ListItemPanel(this.frame, LocalInfo.ins_id + "1");

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		reLayout();

		choose.car.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				newList = new ListItemPanel(frame, LocalInfo.ins_id + "1");
				choose.plane.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
		
		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newList = new ListItemPanel(frame, LocalInfo.ins_id + "2");
				choose.car.toNomal();
				choose.plane.toNomal();
				reLayout();
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newList = new ListItemPanel(frame, LocalInfo.ins_id + "3");	
				choose.car.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
	}

	public void reLayout() {
		removeAll();
		
		JPanel panel = new JPanel();
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, newList, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 4, 1, 1, 1, 0);
		
		frame.validate();
	}

}
