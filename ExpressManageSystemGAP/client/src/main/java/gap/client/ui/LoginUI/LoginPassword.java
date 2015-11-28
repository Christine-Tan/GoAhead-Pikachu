package gap.client.ui.LoginUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import gap.client.ui.UITools.ColorAndFonts;



public class LoginPassword extends JPasswordField implements TextInterface{

	Image image;
	Font font = ColorAndFonts.English;
	boolean hadFoucsed = false;
	LoginButton loginButton;
	KeyListener keyListener;
	
	public LoginPassword(LoginButton loginButton){	
		this.loginButton = loginButton;
		image = new ImageIcon("images/login/lock.png").getImage();
		setEchoChar('\0');
		setBounds(35, 235, 360, 30);
		setFont(font);
		setForeground(Color.gray);
		setText("Password");
		new LoginTextListener(this);
		keyListener = new MyKeyListener();
		addKeyListener(keyListener);
		
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
	
	class MyKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyChar()==KeyEvent.VK_ENTER)
			{ 
		         loginButton.enterPressed(e);
		    } 
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyChar()==KeyEvent.VK_ENTER)
			{ 
		         loginButton.enterReleased(e);
		    } 
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
