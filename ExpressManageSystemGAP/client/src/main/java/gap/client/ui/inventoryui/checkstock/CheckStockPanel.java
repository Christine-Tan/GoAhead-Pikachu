package gap.client.ui.inventoryui.checkstock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ChooseButton;
import gap.client.util.LocalInfo;
import gap.client.util.WareHouseSize;

import java.awt.Color;
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
	MainFrame frame;
	CheckStockPanel self;

	public CheckStockPanel(final MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.self = this;

		choose = new ChoosePanel();
		buttonArea = new StockCheckButtonArea();
		shelves = WareHouseSize.SHELF.getSize();
		list = new ListPanel(shelves, LocalInfo.ins_id + "1");

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		reLayout();
		
		choose.car.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "1");
				setButtonNomal(choose.flex);
				setButtonNomal(choose.train);
				setButtonNomal(choose.plane);
				
				reLayout();
//				frame.paint(self);
			}

		});

		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "2");
//				list.setVisible(true);
				setButtonNomal(choose.flex);
				setButtonNomal(choose.car);
				setButtonNomal(choose.plane);
				reLayout();
				
//				frame.paint(self);
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "3");
				setButtonNomal(choose.flex);
				setButtonNomal(choose.train);
				setButtonNomal(choose.car);
				reLayout();
//				frame.paint(self);
			}
		});
		
		choose.flex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "0");
				setButtonNomal(choose.car);
				setButtonNomal(choose.train);
				setButtonNomal(choose.plane);
				reLayout();
//				frame.paint(self);
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
		JPanel panel = new JPanel();
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 2, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);
		frame.validate();

	}

}
