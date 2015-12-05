package gap.client.ui.inventoryui.stockoutorderinput;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPComboBox;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockoutInfoPanel extends JPanel{
	JLabel title,outDate,targetIns,id,transport;
	JTextField outDate_text,targetIns_text,id_text;
	JComboBox<String> transport_list;
	
	public StockoutInfoPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,120));
		
		title = new GAPLabel("出库单信息：");
		
		outDate = new GAPLabel("出库日期");
		outDate_text = new GAPTextField(10); 
		
		targetIns = new GAPLabel("目的地");
		targetIns_text = new GAPTextField(10);
		
		id = new GAPLabel("中转单编号");
		id_text = new GAPTextField(20);
		
		transport = new GAPLabel("货运方式");
		transport_list = new GAPComboBox<String>();
		transport_list.setPreferredSize(new Dimension(140,25));
		transport_list.addItem("       汽车运输");
		transport_list.addItem("       铁路运输");
		transport_list.addItem("       航空运输");
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		gcons.insets = new Insets(10,10,10,10);
		gcons.anchor = GridBagConstraints.EAST;
		SwingConsole.addComponent(gb, gcons, this, title, 0, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.EAST;
		SwingConsole.addComponent(gb, gcons, this, outDate, 1, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.WEST;
		SwingConsole.addComponent(gb, gcons, this, outDate_text, 2, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.EAST;
		gcons.insets = new Insets(10,0,10,10);
		SwingConsole.addComponent(gb, gcons, this, targetIns, 3, 0, 1, 1, 1, 0);
		gcons.insets = new Insets(10,10,10,10);
		gcons.anchor = GridBagConstraints.WEST;
		SwingConsole.addComponent(gb, gcons, this, targetIns_text, 4, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.EAST;
		SwingConsole.addComponent(gb, gcons, this, id, 1, 1, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.WEST;
		SwingConsole.addComponent(gb, gcons, this, id_text, 2, 1, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.EAST;
		gcons.insets = new Insets(10,0,10,10);
		SwingConsole.addComponent(gb, gcons, this, transport, 3, 1, 1, 1, 1, 0);
		gcons.insets = new Insets(10,10,10,10);
		gcons.anchor = GridBagConstraints.WEST;
		SwingConsole.addComponent(gb, gcons, this, transport_list, 4, 1, 1, 1, 1, 0);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		
		int width = getWidth(),height = getHeight();
		g2d.drawLine(10, height-5, width-20, height-5);
	}
}
