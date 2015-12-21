package gap.client.ui.inventoryui.initialstock;

import gap.client.blcontroller.InventoryController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.ChooseButton;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.FlushButton;
import gap.client.ui.gapcomponents.GAPJScrollPane;
import gap.client.util.LocalInfo;
import gap.client.util.MessageType;
import gap.common.util.ResultMessage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
	JButton flushButton;
	JButton add;

	public InitialStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		this.tframe = frame;
		flushButton = new FlushButton();
		confirm = new ButtonArea();
		confirm.submit.setText("确认初始化");
		title = new TitlePanel();
		choose = new ChoosePanel();
		initial(LocalInfo.ins_id + "1");
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		gcons.fill = GridBagConstraints.BOTH;
		setLayout(gb);

		reLayout();
		
		flushButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainFrame.load(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						refresh();
					}
				});
				MainFrame.setMessage("刷新成功", MessageType.succeed, 3000);
			}

		});

		choose.car.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				initial(LocalInfo.ins_id + "1");
				choose.plane.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
		
		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initial(LocalInfo.ins_id + "2");
				choose.car.toNomal();
				choose.plane.toNomal();
				reLayout();
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initial(LocalInfo.ins_id + "3");
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
					MainFrame.setMessage("初始化成功", MessageType.succeed, 3000);
				}else{
					MainFrame.setMessage("初始化失败，原因嘛··············你猜！", MessageType.alram, 3000);
				}
			}
		});
	}

	public void reLayout() {
		removeAll();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		gcons.insets = new Insets(10, 740, 0, -20);
		SwingConsole.addComponent(gb, gcons, this, flushButton, 0, 0, 1, 1, 1,
				0);
		
		gcons.insets = new Insets(0, 0, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 2, 1, 1, 1, 0); 
		
		GAPJScrollPane js = new GAPJScrollPane(newList);
		js.setPreferredSize(new Dimension(Default.PANEL_WIDTH,Math.min(newList.items.size()+1,8)*50+40));
		
		SwingConsole.addComponent(gb, gcons, this, js, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 4, 1, 1, 1, 0.5);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 5, 1, 1, 1, 0);
		
		tframe.validate();
	}
	
	public void initial(String sector_id){
		choose.car.toNomal();
		choose.train.toNomal();
		choose.plane.toNomal();
		newList = new ListItemPanel(tframe, sector_id);
		add =  newList.addButton;
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reLayout();
			}
		});

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		initial(LocalInfo.ins_id + "1");
		reLayout();
	}

}
