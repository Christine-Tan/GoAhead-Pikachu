package gap.client.ui.inventoryui.initialstock;

import gap.client.blcontroller.InventoryController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.ChooseButton;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.util.LocalInfo;
import gap.client.util.MessageType;
import gap.common.util.ResultMessage;

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
	JFrame tframe;

	public InitialStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		this.tframe = frame;

		initial();

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		reLayout();

		choose.car.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				newList = new ListItemPanel(tframe, LocalInfo.ins_id + "1");
				choose.plane.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
		
		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newList = new ListItemPanel(tframe, LocalInfo.ins_id + "2");
				choose.car.toNomal();
				choose.plane.toNomal();
				reLayout();
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newList = new ListItemPanel(tframe, LocalInfo.ins_id + "3");	
				choose.car.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
		
		confirm.submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ResultMessage re = InventoryController.InitialFlush();
				if(re.equals(ResultMessage.SUCCEED)){
					MainFrame.setMessage("初始化成功", MessageType.succeed, 2000);
				}
			}
		});
	}

	public void reLayout() {
		removeAll();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, newList, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 4, 1, 1, 1, 0);
		
		tframe.validate();
	}
	
	public void initial(){
		confirm = new ButtonArea();
		confirm.submit.setText("确认初始化");
		title = new TitlePanel();
		choose = new ChoosePanel();
		newList = new ListItemPanel(tframe, LocalInfo.ins_id + "1");
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		initial();
		reLayout();
	}

}
