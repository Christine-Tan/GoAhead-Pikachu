package gap.client.ui.inventoryui.stockoutorderinput;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ListItem extends JPanel{
	Checkbox box;
	JLabel id,outDate,targetIns,location;
	
	
	public ListItem(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));
		
		box = new Checkbox();
		
		id = new GAPLabel();
		id.setText("0000000001");
//		id.setControl("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d", 20, 20);
		id.setHorizontalAlignment(JTextField.CENTER);
		
		outDate = new GAPLabel();
		outDate.setText("2015-12-03");
//		inDate.setControl("\\d\\d\\d\\d-\\d\\d-\\d\\d", 10, 10);
		outDate.setHorizontalAlignment(JTextField.CENTER);
		
		targetIns = new GAPLabel();
		targetIns.setText("南京栖霞区");
		targetIns.setHorizontalAlignment(JTextField.CENTER);
		
		location = new GAPLabel();
		location.setHorizontalAlignment(JTextField.CENTER);
		location.setText("A排A架1位");
		
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		
		gcons.insets = new Insets(0,10,0,10);
		gcons.anchor = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, box, 0, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.WEST;
		SwingConsole.addComponent(gb, gcons, this, id, 1, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, outDate, 2, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, targetIns, 3, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, location, 5, 0, 1, 1, 1, 0);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width=getWidth(),height=getHeight();
		g2d.drawLine(20, height-5, width-30, height-5);
	}
	
}
