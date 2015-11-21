package LoginUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import UITools.ColorAndFonts;

public class LoginPassword extends JPasswordField implements TextInterface{

	Image image;
	Font font = ColorAndFonts.English;
	boolean hadFoucsed = false;
	
	public LoginPassword(){		
		image = new ImageIcon("images/login/lock.png").getImage();
		setEchoChar('\0');
		setBounds(35, 235, 360, 30);
		setFont(font);
		setForeground(Color.gray);
		setText("Password");
		new LoginTextListener(this);
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 330, 5, null);
	}


	@Override
	public boolean hadFocused() {
		// TODO Auto-generated method stub
		return hadFoucsed;
	}


	@Override
	public void setFocused(boolean focused) {
		// TODO Auto-generated method stub
		hadFoucsed = focused;
		if(focused){
			setEchoChar('●');
		}else{
			setEchoChar('\0');
			setForeground(Color.gray);
			setText("Password");
		}
	}
	
}
