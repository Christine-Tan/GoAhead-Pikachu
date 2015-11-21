package LoginUI;
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

import UITools.AreaMaker;
import UITools.ColorAndFonts;
import UITools.RenderSetter;

public class LoginButton extends JLabel{

	Color currentColor = ColorAndFonts.darkBlue;
	Font font = ColorAndFonts.Chinese;
	Area area;
	String text;
	Mylistener mylistener;
	
	public LoginButton(String type){
		switch(type){
			case "signIn": text = "登录"; break;
			case "goBack": text = "返回"; break;
		}
		
		
		setSize(200,35);
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
		//开特效
		Graphics2D g2d = RenderSetter.OpenRender(g);
		
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
			currentColor = ColorAndFonts.blue;
			repaint();
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			currentColor = ColorAndFonts.darkBlue;
			repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			currentColor = ColorAndFonts.lightBlue;
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			currentColor = ColorAndFonts.blue;
			repaint();
		}
		
		
		
	}
	
}
