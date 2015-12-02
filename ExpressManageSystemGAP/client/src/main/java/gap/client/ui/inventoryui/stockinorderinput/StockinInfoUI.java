package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.ui.UITools.Defaut;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	public StockinInfoUI (){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 70));
		
		title = new GAPLabel("入库单信息：");
		title.setFont(ComponentStyle.defaultFont);
		
		date = new GAPLabel("入库日期");
		date.setFont(ComponentStyle.defaultFont);
		date_text = new GAPTextField(10);
		
		id = new GAPLabel("入库单编号");
		id.setFont(ComponentStyle.defaultFont);
		id_text = new GAPTextField(20);
		
		grid = new GridBagLayout();
		gcon = new GridBagConstraints();
//		gcon.insets = new Insets(10, 10, 10, 10);
		gcon.anchor = GridBagConstraints.CENTER;
		setLayout(grid);
		
		SwingConsole.addComponent(grid, gcon, this, title, 0, 0, 1, 1, 0, 0);
		gcon.fill = GridBagConstraints.HORIZONTAL;
		
		SwingConsole.addComponent(grid, gcon, this,date, 1, 0, 1, 1, 0, 0);
		SwingConsole
				.addComponent(grid, gcon, this, date_text, 2, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, id, 3, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(grid, gcon, this, id_text, 4, 0, 1, 1, 0,
				0);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		
		int width = getWidth(),height = getHeight();
		g2d.drawLine(10, height-5, width-20, height-5);
	}
	
}
