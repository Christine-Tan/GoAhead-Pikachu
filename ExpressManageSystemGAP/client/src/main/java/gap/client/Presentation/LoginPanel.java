package gap.client.Presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	
	private JTextField userName = new LoginTextField("people");
	private JPasswordField passwordField = new LoginPassword();
	private LogButton signInButton = new LogButton("signIn");
	private LogButton goBackButton = new LogButton("goBack");
	private ExitButton exitButton = new ExitButton();
	
	
	Image background = new ImageIcon("images/login/loginForm.png").getImage();
	
	public LoginPanel(){
		setLayout(null);
		setBounds(0,0,400,300);
		
		add(userName);
		add(passwordField);
		
		signInButton.setBounds(280, 225, 100, 40);
		goBackButton.setBounds(20, 225, 100, 40);
		exitButton.setBounds(360,25,15,15);

		add(signInButton);
		add(goBackButton);
		add(exitButton);		
	}
	
	
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(background, 0, 0, 400, 300, null);
		g2d.setColor(Color.white);
		g2d.setFont(ColorAndFonts.Chinese);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		g2d.drawString("GAP 快递物流系统", 20, 40);
		
		
	}
	
	
	
	
	
	
}
