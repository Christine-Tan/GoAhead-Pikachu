package gap.client.ui.inventoryui.stockinorderinput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import gap.client.ui.UITools.Defaut;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonArea extends JPanel{
	public JButton confirm;
	
	public ButtonArea(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH,60));
		
		confirm = new GAPButton("确认入库");
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.anchor = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 0, 1, 1, 1, 0);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth();
		g2d.drawLine(10, 5, width-20, 5);
	}

}
