package gap.client.ui.inventoryui;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockinInfoUI extends JPanel{
	JLabel title,date,id;
	JTextField date_text,id_text;
	GridBagLayout grid;
	GridBagConstraints gcon;
	
	public StockinInfoUI (String titleName){
		setBackground(Color.white);
		setPreferredSize(new Dimension(850, 150));
		
		title = new GAPLabel(titleName);
		title.setFont(ComponentStyle.defaultFont);
		
		date = new GAPLabel("入库日期");
		date.setFont(ComponentStyle.defaultFont);
		date_text = new GAPTextField(10);
		
		id = new GAPLabel("入库单编号");
		id.setFont(ComponentStyle.defaultFont);
		id_text = new GAPTextField(20);
		
		
		grid = new GridBagLayout();
		gcon = new GridBagConstraints();
		gcon.insets = new Insets(10, 10, 10, 10);
		gcon.anchor = GridBagConstraints.CENTER;
		setLayout(grid);
		SwingConsole.addComponent(grid, gcon, this, title, 0, 0, 1, 1, 0, 0);
		gcon.fill = GridBagConstraints.HORIZONTAL;
		
		SwingConsole.addComponent(grid, gcon, this,date, 1, 0, 1, 1, 0, 0);
		SwingConsole
				.addComponent(grid, gcon, this, date_text, 2, 0, 3, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, id, 8, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, id_text, 9, 0, 1, 1, 0,
				0);
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setContentPane(new StockinInfoUI("入库单信息:"));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(800, 600);
		jf.setVisible(true);
	}
}
