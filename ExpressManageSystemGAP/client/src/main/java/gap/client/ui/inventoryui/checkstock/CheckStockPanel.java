package gap.client.ui.inventoryui.checkstock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ChooseButton;
import gap.client.ui.gapcomponents.GAPJScrollPane;
import gap.client.util.LocalInfo;
import gap.client.util.WareHouseSize;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckStockPanel extends MainPanel {
	StockCheckButtonArea buttonArea;
	public ListPanel list;
	ChoosePanel choose;
	int shelves;
	GridBagLayout gb;
	GridBagConstraints gcons;
	MainFrame mainFrame;
	CheckStockPanel self;

	public CheckStockPanel(final MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		mainFrame = frame;
		shelves = WareHouseSize.SHELF.getSize();
		choose = new ChoosePanel();
		buttonArea = new StockCheckButtonArea();
		shelves = WareHouseSize.SHELF.getSize();
		list = new ListPanel(shelves, LocalInfo.ins_id + "1");

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		gcons.fill = GridBagConstraints.BOTH;
		setLayout(gb);

		reLayout();
		
		choose.car.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				list = new ListPanel(shelves, LocalInfo.ins_id + "1");
				choose.flex.toNomal();
				choose.train.toNomal();
				choose.plane.toNomal();
				
				reLayout();
			}

		});

		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "2");
//				list.setVisible(true);
				choose.flex.toNomal();
				choose.car.toNomal();
				choose.plane.toNomal();
				reLayout();
				
//				MainFrame.paint(self);
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "3");
				choose.flex.toNomal();
				choose.train.toNomal();
				choose.car.toNomal();
				reLayout();
//				MainFrame.paint(self);
			}
		});
		
		choose.flex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "0");
				choose.car.toNomal();
				choose.train.toNomal();
				choose.plane.toNomal();
				reLayout();
//				MainFrame.paint(self);
			}
		});

	}
	
	public void paint(CheckStockPanel panel){
		for(int i = 0;i<panel.list.items.size();i++){
			ListItem item = panel.list.items.get(i);
			for(int j = 0;j<item.shelf.length;j++){
				Unit unit = item.shelf[j];
				unit.icon.paint();
			}
		}
	}
	
	public void setButtonNomal(ChooseButton button){
		button.setBackground(Color.white);
		button.setForeground(ColorAndFonts.blue);
		button.clicked = false;
		
	}
	
	public void reLayout(){
		removeAll();
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.white);
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 0, 1, 1, 1, 0);
		
		GAPJScrollPane js = new GAPJScrollPane(list);
		js.setPreferredSize(new Dimension(Default.PANEL_WIDTH,400));
		
		SwingConsole.addComponent(gb, gcons, this, js, 0, 1, 1, 1, 1, 1);
//		SwingConsole.addComponent(gb, gcons, this, panel, 0, 2, 1, 1, 1, 0.1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);
		mainFrame.validate();

	}
	
	public void initial(){
		list = new ListPanel(shelves, LocalInfo.ins_id + "1");
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		initial();
		choose.car.toNomal();
		choose.flex.toNomal();
		choose.train.toNomal();
		choose.plane.toNomal();
		reLayout();
	}

}
