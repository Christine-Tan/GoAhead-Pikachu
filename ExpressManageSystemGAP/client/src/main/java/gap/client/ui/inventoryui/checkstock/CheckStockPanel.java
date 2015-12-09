package gap.client.ui.inventoryui.checkstock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.util.LocalInfo;
import gap.client.util.WareHouseSize;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckStockPanel extends MainPanel {
	StockCheckButtonArea buttonArea;
	ListPanel list;
	ChoosePanel choose;
	int shelves;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JFrame frame;

	public CheckStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

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
				list = new ListPanel(shelves, LocalInfo.ins_id + "1");
				reLayout();
			}

		});

		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("CAR!!!!!!!!!!!!!!");
				list.removeAll();
				list = new ListPanel(shelves, LocalInfo.ins_id + "2");
//				list.setVisible(true);
				reLayout();
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				list = new ListPanel(shelves, LocalInfo.ins_id + "3");
				reLayout();
			}
		});

	}
	
	public void reLayout(){
		JPanel panel = new JPanel();
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 2, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);
		frame.validate();

	}

}
