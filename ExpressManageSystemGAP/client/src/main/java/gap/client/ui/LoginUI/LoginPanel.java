package gap.client.ui.LoginUI;

import gap.client.ui.BaseComponents.WhiteExitButton;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	private JTextField userName = new LoginTextField("people");
	private LoginButton signInButton = new LoginButton("signIn");
	private JPasswordField passwordField = new LoginPassword(signInButton);
	// private LoginButton goBackButton = new LoginButton("goBack");
	private WhiteExitButton exitButton = new WhiteExitButton();
	private LoginAnimation animation = new LoginAnimation();
	private LogoPanel logoPanel = new LogoPanel();

	// 渐变
	LinearGradientPaint paint;

	Image background = new ImageIcon("images/login/loginForm.png").getImage();

	public LoginPanel() {
		setLayout(null);
		setBounds(0, 0, 430, 330);

		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(layer);
		layer.add(userName);
		layer.add(passwordField);
		layer.add(animation, Integer.valueOf(10));
		animation.startAnimation();

		layer.add(logoPanel, Integer.valueOf(15));
		logoPanel.startAnimation();

		int signInX = getWidth() / 2 - 200 / 2;
		signInButton.setBounds(signInX, 280, 200, 35);
		// goBackButton.setBounds(20, 225, 100, 40);
		exitButton.setBounds(400, 15, 15, 15);

		layer.add(signInButton);
		layer.add(exitButton, new Integer(20));
		
	}

	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = RenderSetter.OpenRender(g);

		g2d.setColor(ColorAndFonts.darkBlue);
		g2d.fillRect(0, 0, this.getWidth(), 60);
		g2d.setColor(Color.white);
		g2d.setFont(ColorAndFonts.Chinese);
		g2d.drawString("GAP 快�?�物流系�?", 20, 40);

	}

}
