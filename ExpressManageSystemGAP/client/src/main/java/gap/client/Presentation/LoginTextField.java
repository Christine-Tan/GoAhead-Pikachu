package gap.client.Presentation;

import javax.swing.*;
import java.awt.*;

public class LoginTextField extends JTextField implements TextInterface{

	Image image;
	Font font = ColorAndFonts.English;
	boolean hadFocused = false;
	public LoginTextField(String type){	
		setFont(font);
		image = new ImageIcon("images/login/"+type+".png").getImage();
		setBounds(20, 90, 360, 50);
		setForeground(Color.gray);
		
		
		if(type=="people"){
			setText("Username");
		}
		new LoginTextListener(this);
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 330, 15, null);
	}
	
	public boolean hadFocused() {
		// TODO Auto-generated method stub
		return hadFocused;
	}


	@Override
	public void setFocused(boolean focused) {
		// TODO Auto-generated method stub
		hadFocused = focused;
		if(!focused){
			setForeground(Color.gray);
			setText("Username");
		}
	}
	
}
