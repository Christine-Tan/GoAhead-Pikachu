package gap.client.Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogButton extends JLabel{

	Color currentColor = ColorAndFonts.purple;
	Font font = ColorAndFonts.Chinese;
	Area area;
	String text;
	Mylistener mylistener;
	
	public LogButton(String type){
		switch(type){
			case "signIn": text = "登录"; break;
			case "goBack": text = "返回"; break;
		}
		
		
		setSize(100,40);
		setForeground(Color.white);
		setOpaque(false);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(font);
		setText(text);

		area = AreaMaker.getRoundRect(getWidth(), getHeight(), 8);
		mylistener = new Mylistener();
		addMouseListener(mylistener);
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		//反锯齿
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		g2d.setColor(currentColor);
		g2d.fill(area);
		super.paintComponent(g2d);
		
	}
	
	
	class Mylistener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			currentColor = ColorAndFonts.orange;
			repaint();
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			currentColor = ColorAndFonts.purple;
			repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	
}
