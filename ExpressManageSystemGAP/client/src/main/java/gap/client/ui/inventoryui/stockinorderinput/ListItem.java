package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.ExpressOrderVO;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ListItem extends JPanel{
	Checkbox box;
	GAPTextField id,inDate,destination,sector,location;
	
	public ListItem(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));
		
		box = new Checkbox();
		
		id = new GAPTextField(7);
		id.setText("0000000001");
//		id.setControl("\\d"+"", 20, 20);
		id.setHorizontalAlignment(JTextField.CENTER);
		
		inDate = new GAPTextField(7);
		inDate.setText("2015-12-03");
//		inDate.setControl("\\d\\d\\d\\d-\\d\\d-\\d\\d", 10, 10);
		inDate.setHorizontalAlignment(JTextField.CENTER);
		
		destination = new GAPTextField(9);
		destination.setText("南京市栖霞区");
		destination.setHorizontalAlignment(JTextField.CENTER);
		
		sector = new GAPTextField(5);
		sector.setHorizontalAlignment(JTextField.CENTER);
		sector.setText("航运区");
		
		location = new GAPTextField(7);
		location.setHorizontalAlignment(JTextField.CENTER);
		location.setText("A排A架1位");
		
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		

		gcons.anchor = GridBagConstraints.CENTER;
		gcons.insets = new Insets(0,20,0,5);
		SwingConsole.addComponent(gb, gcons, this, box, 0, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.WEST;
		gcons.insets = new Insets(0,10,0,10);
		SwingConsole.addComponent(gb, gcons, this, id, 1, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, inDate, 2, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, destination, 3, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, sector, 4, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, location, 5, 0, 1, 1, 1, 0);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width=getWidth(),height=getHeight();
		g2d.drawLine(20, height-5, width-30, height-5);
	}
	
	public void setLine(ExpressOrderVO vo,String date){
		inDate.setText(date);
		inDate.closeEdit();
		
		id.setText(vo.order_id);
		id.closeEdit();
		
//		destination.setText();
	}
	
	
}
